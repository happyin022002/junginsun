/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOmodifyCACnfAIFlagBkgDocProcSkdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOmodifyCACnfAIFlagBkgDocProcSkdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_DOC_PROC_SKD 테이블에 CA로 처리된 AI FLAG 를 CONFIM된 상태로 업데이트 한다.
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOmodifyCACnfAIFlagBkgDocProcSkdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOmodifyCACnfAIFlagBkgDocProcSkdUSQL").append("\n"); 
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
		query.append("UPDATE BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append("SET EVNT_USR_ID = @[ca_no] " ).append("\n"); 
		query.append("WHERE BKG_NO =@[bkg_no] " ).append("\n"); 
		query.append("   AND BKG_DOC_PROC_TP_CD = 'AI_SND'" ).append("\n"); 
		query.append("   AND EVNT_USR_ID = 'CA'" ).append("\n"); 

	}
}