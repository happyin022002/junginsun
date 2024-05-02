/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchClrHubLocCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.23 
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

public class UsaManifestListDownloadDBDAOsearchClrHubLocCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchClrHubLocCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchClrHubLocCdRSQL").append("\n"); 
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
		query.append("SELECT CLR.HUB_LOC_CD, CLR.CSTMS_CLR_TP_CD, CLR.IBD_TRSP_TP_CD IBD_TP_CD, CLR.CSTMS_LOC_CD" ).append("\n"); 
		query.append("      FROM BKG_CSTMS_ADV_CLR_TP CLR" ).append("\n"); 
		query.append("          ,BKG_BOOKING B" ).append("\n"); 
		query.append("#if (${bl_type} == 'H')" ).append("\n"); 
		query.append("          ,BKG_HBL H" ).append("\n"); 
		query.append("          ,BKG_HBL_CUST C" ).append("\n"); 
		query.append("     WHERE H.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("       AND H.HBL_SEQ = C.HBL_SEQ" ).append("\n"); 
		query.append("       AND H.BKG_NO > ' '" ).append("\n"); 
		query.append("       AND H.CNTR_MF_NO = @[bl_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          ,BKG_CUSTOMER C" ).append("\n"); 
		query.append("     WHERE B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("       AND C.BKG_CUST_TP_CD = DECODE(B.CUST_TO_ORD_FLG, 'Y', 'N', 'C')" ).append("\n"); 
		query.append("       AND C.CUST_CNT_CD    = CLR.CUST_CNT_CD" ).append("\n"); 
		query.append("       AND C.CUST_SEQ       = CLR.CUST_SEQ" ).append("\n"); 
		query.append("       AND B.POD_CD         = CLR.POD_CD" ).append("\n"); 
		query.append("	   AND CLR.DELT_FLG ='N'" ).append("\n"); 
		query.append("       AND B.DEL_CD         = DECODE(CLR.DEL_CD, 'ALL', B.DEL_CD, CLR.DEL_CD)" ).append("\n"); 
		query.append("       AND NVL(B.CMDT_CD, 'X') = DECODE(CLR.CMDT_CD, NULL, NVL(B.CMDT_CD, 'X'), CLR.CMDT_CD)" ).append("\n"); 
		query.append("       AND NVL(B.SC_NO, 'X')   = DECODE(CLR.SC_NO, NULL, NVL(B.SC_NO, 'X'), CLR.SC_NO)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ORDER BY CLR.DEL_CD DESC" ).append("\n"); 

	}
}