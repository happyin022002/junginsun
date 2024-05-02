/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PSAManifestDBDAOaddPsaBkgCntrInfoCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.18
*@LastModifier :
*@LastVersion : 1.0
* 2010.08.18
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOaddPsaBkgCntrInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 조회된 파라미터값을 PSA BKG CNTR 테이블에 Insert한다.
	  * </pre>
	  */
	public PSAManifestDBDAOaddPsaBkgCntrInfoCSQL(){
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
		params.put("pbc_cntr_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_dtl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_temp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_len_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("psa_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pbc_cntr_height",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ovr_hgt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("full_mty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_wdt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rd_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("humid_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n");
		query.append("FileName : PSAManifestDBDAOaddPsaBkgCntrInfoCSQL").append("\n");
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
		query.append("INSERT" ).append("\n");
		query.append("INTO BKG_CSTMS_PSA_CNTR" ).append("\n");
		query.append("( BKG_NO" ).append("\n");
		query.append(", BKG_SEQ" ).append("\n");
		query.append(", PSA_SER_NO" ).append("\n");
		query.append(", PSA_IF_CD" ).append("\n");
		query.append(", CNTR_TPSZ_CD" ).append("\n");
		query.append(", FULL_MTY_CD" ).append("\n");
		query.append(", DCGO_FLG" ).append("\n");
		query.append(", RC_FLG" ).append("\n");
		query.append(", RD_CGO_FLG" ).append("\n");
		query.append(", OVR_HGT_FLG" ).append("\n");
		query.append(", OVR_WDT_FLG" ).append("\n");
		query.append(", OVR_LEN_FLG" ).append("\n");
		query.append(", CNTR_KNT" ).append("\n");
		query.append(", RC_TEMP" ).append("\n");
		query.append(", SPCL_CGO_DTL_FLG" ).append("\n");
		query.append(", PSA_CNTR_HGT_CD" ).append("\n");
		query.append(", PSA_CNTR_TPSZ_CD" ).append("\n");
		query.append(", CRE_USR_ID" ).append("\n");
		query.append(", UPD_USR_ID" ).append("\n");
		query.append(", CRE_DT" ).append("\n");
		query.append(", UPD_DT" ).append("\n");
		query.append(", HUMID_NO" ).append("\n");
		query.append(")" ).append("\n");
		query.append("VALUES" ).append("\n");
		query.append("( @[bkg_no]" ).append("\n");
		query.append(", @[bkg_seq]" ).append("\n");
		query.append(", @[psa_ser_no]" ).append("\n");
		query.append(", @[psa_if_cd]" ).append("\n");
		query.append(", @[cntr_tpsz_cd]" ).append("\n");
		query.append(", @[full_mty_cd]" ).append("\n");
		query.append(", @[dcgo_flg]" ).append("\n");
		query.append(", @[rc_flg]" ).append("\n");
		query.append(", @[rd_cgo_flg]" ).append("\n");
		query.append(", @[ovr_hgt_flg]" ).append("\n");
		query.append(", @[ovr_wdt_flg]" ).append("\n");
		query.append(", @[ovr_len_flg]" ).append("\n");
		query.append(", LPAD( 1, 2, '0' )" ).append("\n");
		query.append(", @[rc_temp]" ).append("\n");
		query.append(", @[spcl_cgo_dtl_flg]" ).append("\n");
		query.append(", @[pbc_cntr_height]" ).append("\n");
		query.append(", @[pbc_cntr_tp]" ).append("\n");
		query.append(", @[usr_id]" ).append("\n");
		query.append(", @[usr_id]" ).append("\n");
		query.append(", SYSDATE" ).append("\n");
		query.append(", SYSDATE" ).append("\n");
		query.append(", @[humid_no]" ).append("\n");
		query.append(")" ).append("\n");

	}
}