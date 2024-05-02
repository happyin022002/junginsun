/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingUtilDBDAOAddBkgStateFirmCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOAddBkgStateFirmCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_DOC_PROC_SKD의 'BKGSTF' 상태를 생성한다.
	  * </pre>
	  */
	public BookingUtilDBDAOAddBkgStateFirmCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration ").append("\n"); 
		query.append("FileName : BookingUtilDBDAOAddBkgStateFirmCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_DOC_PROC_SKD(" ).append("\n"); 
		query.append("            BKG_NO" ).append("\n"); 
		query.append("          , BKG_DOC_PROC_TP_CD" ).append("\n"); 
		query.append("          , DOC_PROC_SEQ" ).append("\n"); 
		query.append("          , EVNT_DT" ).append("\n"); 
		query.append("          , EVNT_GDT" ).append("\n"); 
		query.append("          , EVNT_USR_ID" ).append("\n"); 
		query.append("          , DIFF_RMK" ).append("\n"); 
		query.append("          , DOC_PERF_DELT_FLG" ).append("\n"); 
		query.append("          , CRE_USR_ID" ).append("\n"); 
		query.append("          , CRE_DT" ).append("\n"); 
		query.append("          , UPD_USR_ID" ).append("\n"); 
		query.append("          , UPD_DT)  " ).append("\n"); 
		query.append(" VALUES (@[bkg_no]" ).append("\n"); 
		query.append("       , 'BKGSTF'" ).append("\n"); 
		query.append("       , (SELECT NVL(MAX(DOC_PROC_SEQ), 0) + 1 AS DOC_PROC_SEQ  " ).append("\n"); 
		query.append("            FROM BKG_DOC_PROC_SKD  " ).append("\n"); 
		query.append("           WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("             AND BKG_DOC_PROC_TP_CD = 'BKGSTF')" ).append("\n"); 
		query.append("       , GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(),sysdate,BKG_COM_USER_LOC_FNC(@[cre_usr_id]))" ).append("\n"); 
		query.append("	   , GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(), sysdate, 'GMT')" ).append("\n"); 
		query.append("       , NVL(@[evnt_usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("       , (SELECT DOC_PROC_DESC " ).append("\n"); 
		query.append("	        FROM BKG_DOC_PROC_TP " ).append("\n"); 
		query.append("	       WHERE BKG_DOC_PROC_TP_CD = 'BKGSTF')" ).append("\n"); 
		query.append("       , 'N'" ).append("\n"); 
		query.append("       , NVL(@[cre_usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("       , sysdate" ).append("\n"); 
		query.append("       , NVL(@[upd_usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("       , sysdate" ).append("\n"); 
		query.append("        )   " ).append("\n"); 

	}
}