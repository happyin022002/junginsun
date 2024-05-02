/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PSAManifestDBDAOaddPsaBkgInfoCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.11
*@LastModifier :
*@LastVersion : 1.0
* 2010.02.11
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOaddPsaBkgInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 조회된 파라미터값을 PSA BKG테이블에 Insert한다.
	  * </pre>
	  */
	public PSAManifestDBDAOaddPsaBkgInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psa_if_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_shpr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_shpr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n");
		query.append("FileName : PSAManifestDBDAOaddPsaBkgInfoCSQL").append("\n");
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
		query.append("INSERT INTO BKG_CSTMS_PSA_BKG" ).append("\n");
		query.append("(       BKG_NO          ," ).append("\n");
		query.append("BKG_SEQ         ," ).append("\n");
		query.append("VSL_CD          ," ).append("\n");
		query.append("SKD_VOY_NO      ," ).append("\n");
		query.append("SKD_DIR_CD      ," ).append("\n");
		query.append("PSA_IF_CD       ," ).append("\n");
		query.append("N1ST_SHPR_NM    ," ).append("\n");
		query.append("N2ND_SHPR_NM    ," ).append("\n");
		query.append("POD_CD          ," ).append("\n");
		query.append("N1ST_POD_CD     ," ).append("\n");
		query.append("N2ND_POD_CD     ," ).append("\n");
		query.append("N3RD_POD_CD     ," ).append("\n");
		query.append("SND_DT          ," ).append("\n");
		query.append("SND_USR_ID      ," ).append("\n");
		query.append("ACK_RCV_STS_CD  ," ).append("\n");
		query.append("CRE_USR_ID," ).append("\n");
		query.append("UPD_USR_ID," ).append("\n");
		query.append("CRE_DT," ).append("\n");
		query.append("UPD_DT   )" ).append("\n");
		query.append("VALUES" ).append("\n");
		query.append("(       @[bkg_no]," ).append("\n");
		query.append("@[bkg_seq]," ).append("\n");
		query.append("@[vsl_cd]," ).append("\n");
		query.append("@[skd_voy_no]," ).append("\n");
		query.append("@[skd_dir_cd]," ).append("\n");
		query.append("@[psa_if_cd]," ).append("\n");
		query.append("@[n1st_shpr_nm]," ).append("\n");
		query.append("@[n2nd_shpr_nm]," ).append("\n");
		query.append("@[pod_cd]," ).append("\n");
		query.append("@[n1st_pod_cd]," ).append("\n");
		query.append("@[n2nd_pod_cd]," ).append("\n");
		query.append("@[n3rd_pod_cd]," ).append("\n");
		query.append("SYSDATE         ," ).append("\n");
		query.append("@[snd_usr_id]," ).append("\n");
		query.append("'N'           ," ).append("\n");
		query.append("@[snd_usr_id]," ).append("\n");
		query.append("@[snd_usr_id]," ).append("\n");
		query.append("SYSDATE," ).append("\n");
		query.append("SYSDATE  )" ).append("\n");

	}
}