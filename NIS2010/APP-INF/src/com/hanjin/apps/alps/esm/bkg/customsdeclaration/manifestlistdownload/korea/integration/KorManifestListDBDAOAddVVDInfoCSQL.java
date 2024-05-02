/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDBDAOAddVVDInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.06.11 손윤석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son Yun Seuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOAddVVDInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD Seq = 0이면 VVD Information을 Insert한다
	  * </pre>
	  */
	public KorManifestListDBDAOAddVVDInfoCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_call_sign",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_mrn_chk_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("username",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("joint_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_pod_tmnl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("createdtype",new String[]{arrTmp[0],arrTmp[1]});
		
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

	}
	/**
	 * 
	 */
	public String getSQL(){
		return query.toString();
	}
	/**
	 * 
	 */
	public HashMap<String,String[]> getParams() {
		return params;
	}
	
	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("INSERT INTO BKG_CSTMS_KR_VVD_SMRY" ).append("\n"); 
		query.append("(MRN_NO, MRN_CHK_NO, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, OB_DECL_TP_CD," ).append("\n"); 
		query.append("PORT_CD, IO_BND_CD, VSL_CNT_CD, VSL_NM, KR_VSL_CALL_SGN_CD," ).append("\n"); 
		query.append("ETA_DT, ETD_DT," ).append("\n"); 
		query.append("MST_BL_KNT, CNSL_BL_KNT, TTL_WGT, TTL_MEAS_QTY, TTL_PCK_QTY, TTL_FULL_KNT, TTL_MTY_KNT," ).append("\n"); 
		query.append("JO_CRR_KNT, CRE_DT, CRE_USR_ID, UPD_USR_ID, VVD_SEQ, PORT_TML_CD)" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("( @[new_mrn_no]" ).append("\n"); 
		query.append(", @[new_mrn_chk_no]" ).append("\n"); 
		query.append(", SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append(", SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append(", SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append(", @[createdtype]" ).append("\n"); 
		query.append(", @[mrn_port]" ).append("\n"); 
		query.append(", @[bound]" ).append("\n"); 
		query.append(", @[vsl_flag]" ).append("\n"); 
		query.append(", @[vsl_eng_nm]" ).append("\n"); 
		query.append(", @[vsl_call_sign]" ).append("\n"); 
		query.append(", TO_DATE(@[eta_dt],'YYYYMMDD HH24:MI:SS'), TO_DATE(@[etd_dt],'YYYYMMDD HH24:MI:SS')" ).append("\n"); 
		query.append(", 0, 0, 0, 0, 0, 0, 0" ).append("\n"); 
		query.append(", @[joint_cnt]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[username]" ).append("\n"); 
		query.append(", @[username]" ).append("\n"); 
		query.append(", @[kv_seq]" ).append("\n"); 
		query.append(", @[vvd_pod_tmnl_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ").append("\n"); 
		query.append("FileName : KorManifestListDBDAOAddVVDInfoCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}