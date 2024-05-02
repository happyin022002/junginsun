/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchSREmlCtntVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchSREmlCtntVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchSREmlCtntVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_log_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sr_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchSREmlCtntVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	C.SR_NO" ).append("\n"); 
		query.append(",	C.FAX_LOG_REF_NO" ).append("\n"); 
		query.append(",	C.SR_KND_CD" ).append("\n"); 
		query.append(",	C.EML_MN_CTNT" ).append("\n"); 
		query.append(",	C.CRE_USR_ID" ).append("\n"); 
		query.append(",	C.CRE_DT" ).append("\n"); 
		query.append(",	C.UPD_USR_ID" ).append("\n"); 
		query.append(",	C.UPD_DT" ).append("\n"); 
		query.append(",	EML.EML_SUBJ_CTNT" ).append("\n"); 
		query.append(",	EML.EML_ORG_SUBJ_CTNT" ).append("\n"); 
		query.append(",   (SELECT /*+ INDEX_DESC(MAS_OFC_LVL XPKMAS_OFC_LVL) */ H.ATTR_CTNT2" ).append("\n"); 
		query.append("     FROM COM_USER U, MAS_OFC_LVL O, BKG_HRD_CDG_CTNT H" ).append("\n"); 
		query.append("     WHERE U.USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("     AND U.OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("     AND O.OFC_N2ND_LVL_CD = H.ATTR_CTNT1 --RHQ" ).append("\n"); 
		query.append("     AND H.HRD_CDG_ID = 'SI_TRANS_MAIL'" ).append("\n"); 
		query.append("     AND ROWNUM = 1) RECIPIENT" ).append("\n"); 
		query.append(",   '<ROTATION_SRNO:'||C.SR_NO||'>" ).append("\n"); 
		query.append("<ROTATION_SYS:ALPS>' TEXT_CONTENT" ).append("\n"); 
		query.append("FROM BKG_SR_EML_CTNT C" ).append("\n"); 
		query.append(",	BKG_SR_FAX EML" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND	C.SR_NO(+)	= EML.SR_NO" ).append("\n"); 
		query.append("AND	C.FAX_LOG_REF_NO(+) = EML.FAX_LOG_REF_NO" ).append("\n"); 
		query.append("AND	C.SR_KND_CD(+) = EML.SR_KND_CD" ).append("\n"); 
		query.append("AND	EML.SR_NO = @[sr_no]" ).append("\n"); 
		query.append("AND	EML.FAX_LOG_REF_NO = @[fax_log_ref_no]" ).append("\n"); 
		query.append("AND	EML.SR_KND_CD = @[sr_knd_cd]" ).append("\n"); 

	}
}