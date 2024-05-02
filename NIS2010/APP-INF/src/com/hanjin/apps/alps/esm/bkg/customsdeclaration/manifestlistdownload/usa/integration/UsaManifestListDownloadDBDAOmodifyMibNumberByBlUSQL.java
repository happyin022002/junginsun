/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOmodifyMibNumberByBlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.24
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2012.10.24 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOmodifyMibNumberByBlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, Ibd_Trsp_No 갱신. 0408
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOmodifyMibNumberByBlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pmib_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hub",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOmodifyMibNumberByBlUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_ADV_IBD" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("	IBD_TRSP_NO = DECODE(NVL(CSTMS_CLR_TP_CD, ' '), 'I', @[pmib_no], '')" ).append("\n"); 
		query.append("    ,IBD_TRSP_ISS_DT = GLOBALDATE_PKG.TIME_CONV_FNC ('KRACY', sysdate, 'USNYC')" ).append("\n"); 
		query.append("    ,UPD_USR_ID = @[user_id]" ).append("\n"); 
		query.append("    ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("	(CNT_CD, BL_NO) IN (" ).append("\n"); 
		query.append("		SELECT CNT_CD, BL_NO " ).append("\n"); 
		query.append("		FROM BKG_CSTMS_ADV_BL A" ).append("\n"); 
		query.append("		WHERE A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("			AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("			AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("			AND A.CSTMS_POD_CD = @[pod]" ).append("\n"); 
		query.append("			AND NVL(A.HUB_LOC_CD,'C') = NVL(@[hub],'C')" ).append("\n"); 
		query.append("			AND A.CSTMS_LOC_CD = @[cstms]" ).append("\n"); 
		query.append("			AND A.DEL_CD = @[del]" ).append("\n"); 
		query.append("			AND A.MF_STS_CD = 'A'" ).append("\n"); 
		query.append("			AND A.CNT_CD = 'US'" ).append("\n"); 
		query.append("			AND A.BL_NO = NVL(@[bl_no], A.BL_NO)" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}