/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.13
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaBlHistoryVO
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchHistoryRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  H.HIS_TP_ID" ).append("\n"); 
		query.append(",H.HIS_SEQ" ).append("\n"); 
		query.append(",D.HIS_SUB_SEQ" ).append("\n"); 
		query.append(",D.HIS_ITM_CTNT" ).append("\n"); 
		query.append(",D.PRE_CTNT" ).append("\n"); 
		query.append(",D.CRNT_CTNT" ).append("\n"); 
		query.append(",U.USR_NM" ).append("\n"); 
		query.append(",U.OFC_CD" ).append("\n"); 
		query.append(",TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC ('KRACY', H.UPD_DT, 'USNYC'), 'yyyy-mm-dd hh24:mi:ss') CRE_DT" ).append("\n"); 
		query.append(",H.CRE_USR_ID" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(ORDER BY H.CRE_DT, H.HIS_SEQ, D.HIS_SUB_SEQ) AS RNUM" ).append("\n"); 
		query.append(",COUNT(*) OVER() AS TOTAL" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_IBD_HIS H" ).append("\n"); 
		query.append(",BKG_CSTMS_IBD_HIS_DTL D" ).append("\n"); 
		query.append(",COM_USER U" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     H.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND     H.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND     H.CNT_CD = D.CNT_CD" ).append("\n"); 
		query.append("AND     H.BL_NO = D.BL_NO" ).append("\n"); 
		query.append("AND     H.HIS_SEQ = D.HIS_SEQ" ).append("\n"); 
		query.append("AND     H.CRE_USR_ID = U.USR_ID(+)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE RNUM BETWEEN @[start_no] AND @[end_no]" ).append("\n"); 

	}
}