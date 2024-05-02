/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Kor24ManifestListDBDAOaddEmptyCorrInfoCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.26
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.05.26 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOaddEmptyCorrInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Empty Amend INSERT
	  * </pre>
	  */
	public Kor24ManifestListDBDAOaddEmptyCorrInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("corr_reason",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n");
		query.append("FileName : Kor24ManifestListDBDAOaddEmptyCorrInfoCSQL").append("\n");
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
		query.append("INSERT INTO BKG_CSTMS_KR_CORR (" ).append("\n");
		query.append("SMT_AMD_NO, bkg_no, CSTMS_DECL_TP_CD, bl_no," ).append("\n");
		query.append("KR_CSTMS_CORR_ID, CORR_RSN, CRE_DT,   CRE_USR_ID,   UPD_DT," ).append("\n");
		query.append("UPD_USR_ID,   AMDT_SND_DT,  AMDT_SND_USR_ID,  RSPN_RCV_DT,  CLT_SEQ, PORT_CD," ).append("\n");
		query.append("AMDT_RCVR_CD, KR_VSL_CALL_SGN_CD,   CALL_YR, CALL_KNT,  VSL_NM," ).append("\n");
		query.append("VSL_RGST_CNT_CD,    DCHG_MZD_CD,   IO_TML_LOC_CD, vsl_cd,     skd_voy_no," ).append("\n");
		query.append("skd_dir_cd, CSTMS_BL_NO)" ).append("\n");
		query.append("SELECT  @[sub_no], @[bkg_no], 'T', @[bl_no]," ).append("\n");
		query.append("@[corr_cd], @[corr_reason], sysdate, @[usr_id], sysdate," ).append("\n");
		query.append("@[usr_id], sysdate, NULL, NULL, @[clt_seq], @[port_cd]," ).append("\n");
		query.append("NULL, NULL, NULL, NULL, NULL, NULL, NULL," ).append("\n");
		query.append("NULL, SUBSTR(@[vvd_cd],1,4), SUBSTR(@[vvd_cd],5,4), SUBSTR(@[vvd_cd],9,1), @[cstms_bl_no]" ).append("\n");
		query.append("FROM    DUAL" ).append("\n");

	}
}