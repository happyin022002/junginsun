/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PSAManifestDBDAOaddUnmatchPsaListCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier :
*@LastVersion : 1.0
* 2009.10.22
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOaddUnmatchPsaListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Psa List 추가
	  * </pre>
	  */
	public PSAManifestDBDAOaddUnmatchPsaListCSQL(){
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
		params.put("cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rly_port",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("und_deck_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("special",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration ").append("\n");
		query.append("FileName : PSAManifestDBDAOaddUnmatchPsaListCSQL").append("\n");
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
		query.append("INTO BKG_CSTMS_PSA_CNTR_CHK" ).append("\n");
		query.append("( VSL_CD" ).append("\n");
		query.append(", SKD_VOY_NO" ).append("\n");
		query.append(", SKD_DIR_CD" ).append("\n");
		query.append(", RLY_PORT_CD" ).append("\n");
		query.append(", CNTR_NO" ).append("\n");
		query.append(", VVD_NM" ).append("\n");
		query.append("#if(${trans_tp_cd}!='E')" ).append("\n");
		query.append(", POL_CD  /** IMPORT 시에 POL_CD 사용 **/" ).append("\n");
		query.append("#else" ).append("\n");
		query.append(", POD_CD  /** IMPORT 시에 POL_CD 사용 **/" ).append("\n");
		query.append("#end" ).append("\n");
		query.append(", PSA_CNTR_TPSZ_CD" ).append("\n");
		query.append(", CNTR_TPSZ_CD" ).append("\n");
		query.append(", UND_DECK_TP_ID" ).append("\n");
		query.append(", SPCL_CGO_DTL_CTNT" ).append("\n");
		query.append(", CRE_USR_ID" ).append("\n");
		query.append(", CRE_DT" ).append("\n");
		query.append(", UPD_USR_ID" ).append("\n");
		query.append(", UPD_DT )" ).append("\n");
		query.append("VALUES" ).append("\n");
		query.append("( SUBSTR(@[vvd],1,4)" ).append("\n");
		query.append(", SUBSTR(@[vvd],5,4)" ).append("\n");
		query.append(", SUBSTR(@[vvd],9,1)" ).append("\n");
		query.append(", @[rly_port]" ).append("\n");
		query.append(", REPLACE(@[cntr_no],' ','')" ).append("\n");
		query.append(", @[vvd_nm]" ).append("\n");
		query.append(", DECODE(@[port_cd],'USLB1','USLGB','USLB2','USLGB','USLB3','USLGB','USLB4','USLGB','USLBH','USLGB',@[port_cd]) /** IMPORT 시에는 :POL_LOC 임 **/" ).append("\n");
		query.append(", @[cntr_tp_cd]||@[cntr_sz_cd]" ).append("\n");
		query.append(", ''" ).append("\n");
		query.append(", TRIM(@[und_deck_tp_id])" ).append("\n");
		query.append(", RTRIM(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(@[special],'/DG-N',''),'/DG-Y',''),'/ DG-S',''),'RF',''), ',HIGH CUBE', ''), 'HIGH CUBE', ''))" ).append("\n");
		query.append(", @[user_id]" ).append("\n");
		query.append(", SYSDATE" ).append("\n");
		query.append(", @[user_id]" ).append("\n");
		query.append(", SYSDATE" ).append("\n");
		query.append(")" ).append("\n");

	}
}