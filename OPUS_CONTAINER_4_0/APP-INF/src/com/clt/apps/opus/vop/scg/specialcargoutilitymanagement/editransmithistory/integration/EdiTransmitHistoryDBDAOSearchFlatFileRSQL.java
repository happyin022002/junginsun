/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EdiTransmitHistoryDBDAOSearchFlatFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EdiTransmitHistoryDBDAOSearchFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FlatFile Contents 조회
	  * </pre>
	  */
	public EdiTransmitHistoryDBDAOSearchFlatFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnr_spcl_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.integration").append("\n"); 
		query.append("FileName : EdiTransmitHistoryDBDAOSearchFlatFileRSQL").append("\n"); 
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
		query.append("SELECT TRSM_BND_CD, FLT_FILE_DAT_CTNT " ).append("\n"); 
		query.append("FROM SCG_PRNR_SPCL_CGO_FLT_FILE" ).append("\n"); 
		query.append("WHERE BKG_REF_NO = @[bkg_ref_no]" ).append("\n"); 
		query.append("AND PRNR_SPCL_CGO_SEQ = @[prnr_spcl_cgo_seq]" ).append("\n"); 

	}
}