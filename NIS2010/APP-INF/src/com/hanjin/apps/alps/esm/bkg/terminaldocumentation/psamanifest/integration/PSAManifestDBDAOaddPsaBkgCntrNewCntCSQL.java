/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PSAManifestDBDAOaddPsaBkgCntrNewCntCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.11
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.02.11 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOaddPsaBkgCntrNewCntCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSA BKG CNTR의 new count를 add한다.
	  * </pre>
	  */
	public PSAManifestDBDAOaddPsaBkgCntrNewCntCSQL(){
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
		params.put("cntr_cnt_new",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("psa_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add_val",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n"); 
		query.append("FileName : PSAManifestDBDAOaddPsaBkgCntrNewCntCSQL").append("\n"); 
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
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append(", BKG_SEQ" ).append("\n"); 
		query.append(", PSA_SER_NO + @[add_val]" ).append("\n"); 
		query.append(", PSA_IF_CD" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", FULL_MTY_CD" ).append("\n"); 
		query.append(", DCGO_FLG" ).append("\n"); 
		query.append(", RC_FLG" ).append("\n"); 
		query.append(", RD_CGO_FLG" ).append("\n"); 
		query.append(", OVR_HGT_FLG" ).append("\n"); 
		query.append(", OVR_WDT_FLG" ).append("\n"); 
		query.append(", OVR_LEN_FLG" ).append("\n"); 
		query.append(", LPAD( @[cntr_cnt_new], 2, '0' )" ).append("\n"); 
		query.append(", RC_TEMP" ).append("\n"); 
		query.append(", SPCL_CGO_DTL_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append("FROM BKG_CSTMS_PSA_CNTR" ).append("\n"); 
		query.append("WHERE BKG_NO     =   @[bkg_no]" ).append("\n"); 
		query.append("AND BKG_SEQ    =   @[bkg_seq]" ).append("\n"); 
		query.append("AND PSA_SER_NO =   @[psa_ser_no]" ).append("\n"); 

	}
}