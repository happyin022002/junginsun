/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchMfrCustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.06
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanManifestListDownloadDBDAOsearchMfrCustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMfrCust
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchMfrCustRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_number",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n"); 
		query.append("FileName : JapanManifestListDownloadDBDAOsearchMfrCustRSQL").append("\n"); 
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
		query.append("	A.BL_NO||A.BL_SPLIT_NO BL_NUMBER," ).append("\n"); 
		query.append("	A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD_CD," ).append("\n"); 
		query.append("	NVL(@[pod_cd], '') POD_CD," ).append("\n"); 
		query.append("	'' CLPT_IND_SEQ," ).append("\n"); 
		query.append("	C1.CUST_CNT_CD CUST_CNT_CD,      " ).append("\n"); 
		query.append("	C1.CUST_SEQ CUST_SEQ," ).append("\n"); 
		query.append("	REPLACE(C1.CUST_NM,'\"','\"\"') CUST_NM," ).append("\n"); 
		query.append("	REPLACE(C1.CUST_ADDR,'\"','\"\"') CUST_ADDR," ).append("\n"); 
		query.append("	C1.PHN_NO PHN_NO,     " ).append("\n"); 
		query.append("	C1.FAX_NO FAX_NO," ).append("\n"); 
		query.append("	C2.CUST_CNT_CD CUST_CNT_CD2,      " ).append("\n"); 
		query.append("	C2.CUST_SEQ CUST_SEQ2," ).append("\n"); 
		query.append("	REPLACE(C2.CUST_NM,'\"','\"\"') CUST_NM2," ).append("\n"); 
		query.append("	REPLACE(C2.CUST_ADDR,'\"','\"\"') CUST_ADDR2," ).append("\n"); 
		query.append("	C2.PHN_NO PHN_NO2,     " ).append("\n"); 
		query.append("	C2.FAX_NO FAX_NO2," ).append("\n"); 
		query.append("	C3.CUST_CNT_CD CUST_CNT_CD3,      " ).append("\n"); 
		query.append("	C3.CUST_SEQ CUST_SEQ3," ).append("\n"); 
		query.append("	REPLACE(C3.CUST_NM,'\"','\"\"') CUST_NM3," ).append("\n"); 
		query.append("	REPLACE(C3.CUST_ADDR,'\"','\"\"') CUST_ADDR3," ).append("\n"); 
		query.append("	C3.PHN_NO PHN_NO3,     " ).append("\n"); 
		query.append("	C3.FAX_NO FAX_NO3" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	BKG_CSTMS_JP_BL A, " ).append("\n"); 
		query.append("	VSK_VSL_PORT_SKD S," ).append("\n"); 
		query.append("	BKG_CSTMS_JP_BL_CUST C1, " ).append("\n"); 
		query.append("	BKG_CSTMS_JP_BL_CUST C2," ).append("\n"); 
		query.append("	BKG_CSTMS_JP_BL_CUST C3 " ).append("\n"); 
		query.append("WHERE A.BL_NO       = SUBSTR(@[bl_number],1,12)" ).append("\n"); 
		query.append("AND A.BL_SPLIT_NO = DECODE(SUBSTR(@[bl_number],13,2),NULL,'  ',SUBSTR(@[bl_number],13,2))" ).append("\n"); 
		query.append("AND A.BL_NO       = C1.BL_NO(+)" ).append("\n"); 
		query.append("AND A.BL_SPLIT_NO = C1.BL_SPLIT_NO(+)" ).append("\n"); 
		query.append("AND C1.BKG_CUST_TP_CD(+)  = 'S'" ).append("\n"); 
		query.append("AND A.BL_NO       = C2.BL_NO(+)" ).append("\n"); 
		query.append("AND A.BL_SPLIT_NO = C2.BL_SPLIT_NO(+)" ).append("\n"); 
		query.append("AND C2.BKG_CUST_TP_CD(+)  = 'C'" ).append("\n"); 
		query.append("AND A.BL_NO       = C3.BL_NO(+)" ).append("\n"); 
		query.append("AND A.BL_SPLIT_NO = C3.BL_SPLIT_NO(+)" ).append("\n"); 
		query.append("AND C3.BKG_CUST_TP_CD(+)  = 'N'" ).append("\n"); 
		query.append("AND A.VSL_CD        = S.VSL_CD(+)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = S.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD    = S.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND A.POD_CD       = S.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("AND S.CLPT_IND_SEQ(+)  = @[clpt_ind_seq]" ).append("\n"); 

	}
}