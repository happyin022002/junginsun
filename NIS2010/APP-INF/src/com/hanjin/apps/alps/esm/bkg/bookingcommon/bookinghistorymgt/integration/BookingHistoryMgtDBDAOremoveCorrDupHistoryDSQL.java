/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOremoveCorrDupHistoryDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.02.08 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOremoveCorrDupHistoryDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_HIS_DTL 테이블의 특정Bkg_no의 중복되는 history를 삭제한다
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOremoveCorrDupHistoryDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOremoveCorrDupHistoryDSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("DELETE BKG_HIS_DTL" ).append("\n"); 
		query.append("WHERE (BKG_NO,HIS_SEQ,HIS_DTL_SEQ) IN" ).append("\n"); 
		query.append("(SELECT DTL.BKG_NO,DTL.HIS_SEQ,DTL.HIS_DTL_SEQ" ).append("\n"); 
		query.append("FROM BKG_HIS_DTL DTL," ).append("\n"); 
		query.append("(SELECT MST.BKG_NO" ).append("\n"); 
		query.append(", MST.CORR_NO" ).append("\n"); 
		query.append(", DTL.PRE_CTNT" ).append("\n"); 
		query.append(", DTL.CRNT_CTNT" ).append("\n"); 
		query.append(", MIN(DTL.HIS_SEQ) MIN_HIS_SEQ" ).append("\n"); 
		query.append(", COUNT(1) CNT" ).append("\n"); 
		query.append("FROM BKG_HIS_DTL DTL, BKG_HIS_MST MST" ).append("\n"); 
		query.append("WHERE MST.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("AND MST.BKG_NO  = DTL.BKG_NO" ).append("\n"); 
		query.append("AND MST.HIS_SEQ = DTL.HIS_SEQ" ).append("\n"); 
		query.append("AND MST.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("GROUP BY MST.BKG_NO, MST.CORR_NO, DTL.PRE_CTNT, DTL.CRNT_CTNT) DUP_HIS" ).append("\n"); 
		query.append("WHERE DTL.BKG_NO              = DUP_HIS.BKG_NO" ).append("\n"); 
		query.append("AND DTL.HIS_SEQ             > DUP_HIS.MIN_HIS_SEQ        -- 나중에 생긴 history" ).append("\n"); 
		query.append("AND NVL(DTL.PRE_CTNT,  'X') = NVL(DUP_HIS.PRE_CTNT,  'X')-- 중복되는 history" ).append("\n"); 
		query.append("AND NVL(DTL.CRNT_CTNT, 'X') = NVL(DUP_HIS.CRNT_CTNT, 'X')" ).append("\n"); 
		query.append("AND CNT                     > 1)" ).append("\n"); 

	}
}