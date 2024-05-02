/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PSAManifestDBDAOaddPsaBkgRlsOrdCntrQtyCSQL.java
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

public class PSAManifestDBDAOaddPsaBkgRlsOrdCntrQtyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * pbr_qty > pbr_qty_rest 일 경우 PSA Release Order테이블에 새로 Insert
	  * </pre>
	  */
	public PSAManifestDBDAOaddPsaBkgRlsOrdCntrQtyCSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_psa_ser_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n");
		query.append("FileName : PSAManifestDBDAOaddPsaBkgRlsOrdCntrQtyCSQL").append("\n");
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
		query.append("INTO BKG_CSTMS_PSA_RLSE_ORD" ).append("\n");
		query.append("( BKG_NO" ).append("\n");
		query.append(", BKG_SEQ" ).append("\n");
		query.append(", PSA_SER_NO" ).append("\n");
		query.append(", SUB_PSA_SER_NO" ).append("\n");
		query.append(", PSA_IF_CD" ).append("\n");
		query.append(", YD_CD" ).append("\n");
		query.append(", CNTR_TPSZ_CD" ).append("\n");
		query.append(", CNTR_QTY" ).append("\n");
		query.append(", CRE_USR_ID" ).append("\n");
		query.append(", UPD_USR_ID" ).append("\n");
		query.append(", CRE_DT" ).append("\n");
		query.append(", UPD_DT" ).append("\n");
		query.append(")" ).append("\n");
		query.append("SELECT BKG_NO" ).append("\n");
		query.append(", BKG_SEQ" ).append("\n");
		query.append(", PSA_SER_NO + 1" ).append("\n");
		query.append(", 1" ).append("\n");
		query.append(", PSA_IF_CD" ).append("\n");
		query.append(", YD_CD" ).append("\n");
		query.append(", CNTR_TPSZ_CD" ).append("\n");
		query.append(", @[cntr_qty]" ).append("\n");
		query.append(", CRE_USR_ID" ).append("\n");
		query.append(", UPD_USR_ID" ).append("\n");
		query.append(", SYSDATE" ).append("\n");
		query.append(", SYSDATE" ).append("\n");
		query.append("FROM BKG_CSTMS_PSA_RLSE_ORD" ).append("\n");
		query.append("WHERE BKG_NO         =   @[bkg_no]" ).append("\n");
		query.append("AND BKG_SEQ        =   @[bkg_seq]" ).append("\n");
		query.append("AND PSA_SER_NO     =   @[psa_ser_no]" ).append("\n");
		query.append("AND SUB_PSA_SER_NO =   @[sub_psa_ser_no]" ).append("\n");

	}
}