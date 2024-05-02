/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PSAManifestDBDAOsearchPsaSerialNoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.12
*@LastModifier :
*@LastVersion : 1.0
* 2013.09.12
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

public class PSAManifestDBDAOsearchPsaSerialNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * PSA Serial No를 구한다.
	  * 2010.09.07 김영철 [CHM-201005693-01] BKG_CSTMS_PSA_PLSE_ORD TABLE 추가하여 YD_CD로 조회 수정
	  * 2010.10.07 김영철 [ ] PSA 관련 수정 - 키값이 빠져 문제 발생함 ( AND A.PSA_SER_NO     = B.PSA_SER_NO )
	  * </pre>
	  */
	public PSAManifestDBDAOsearchPsaSerialNoRSQL(){
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : PSAManifestDBDAOsearchPsaSerialNoRSQL").append("\n");
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
		query.append("SELECT A.PSA_SER_NO" ).append("\n");
		query.append("  FROM BKG_CSTMS_PSA_CNTR A, BKG_CSTMS_PSA_RLSE_ORD B" ).append("\n");
		query.append(" WHERE A.BKG_NO        =  @[bkg_no]" ).append("\n");
		query.append("   AND A.BKG_SEQ       =  @[bkg_seq]" ).append("\n");
		query.append("   AND A.CNTR_TPSZ_CD  =  @[cntr_tpsz_cd]" ).append("\n");
		query.append("   AND A.DCGO_FLG      =  @[dcgo_flg]" ).append("\n");
		query.append("   AND A.RC_FLG        =  @[rc_flg]" ).append("\n");
		query.append("   AND A.RD_CGO_FLG    =  @[rd_cgo_flg]" ).append("\n");
		query.append("   AND A.OVR_HGT_FLG   =  @[ovr_hgt_flg]" ).append("\n");
		query.append("   AND A.OVR_WDT_FLG   =  @[ovr_wdt_flg]" ).append("\n");
		query.append("   AND A.OVR_LEN_FLG   =  @[ovr_len_flg]" ).append("\n");
		query.append("#if(${rc_temp}!='')" ).append("\n");
		query.append("   AND A.RC_TEMP       =  @[rc_temp]" ).append("\n");
		query.append("#end " ).append("\n");
		query.append("" ).append("\n");
		query.append("#if(${humid_no}!='')" ).append("\n");
		query.append("   AND A.HUMID_NO      =  @[humid_no]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("" ).append("\n");
		query.append("#if(${pbc_cntr_height}!='')" ).append("\n");
		query.append("   AND A.PSA_CNTR_HGT_CD  = @[pbc_cntr_height]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("" ).append("\n");
		query.append("   AND A.PSA_CNTR_TPSZ_CD = @[pbc_cntr_tp]" ).append("\n");
		query.append("   AND A.BKG_NO         = B.BKG_NO" ).append("\n");
		query.append("   AND A.BKG_SEQ        = B.BKG_SEQ" ).append("\n");
		query.append("   AND A.PSA_CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n");
		query.append("   AND A.PSA_SER_NO     = B.PSA_SER_NO" ).append("\n");
		query.append("   AND B.YD_CD = @[yd_cd]" ).append("\n");

	}
}