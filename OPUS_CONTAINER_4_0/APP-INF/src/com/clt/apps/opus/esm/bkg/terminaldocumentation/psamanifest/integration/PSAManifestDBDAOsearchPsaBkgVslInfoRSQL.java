/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PSAManifestDBDAOsearchPsaBkgVslInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.16 
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

public class PSAManifestDBDAOsearchPsaBkgVslInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSA BKG VSL Info를 조회하여 flat file로 만든다.
	  * </pre>
	  */
	public PSAManifestDBDAOsearchPsaBkgVslInfoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n"); 
		query.append("FileName : PSAManifestDBDAOsearchPsaBkgVslInfoRSQL").append("\n"); 
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
		query.append("SELECT NVL(SUBSTR( PV.PSA_VSL_NM, 1, 12 ),'') PV_VSL_NM" ).append("\n"); 
		query.append("     , NVL(PV.PSA_VOY_DIR_CD,'') PV_VOY_DIR" ).append("\n"); 
		query.append("     , 'D' BKG_FI" ).append("\n"); 
		query.append("     , COM_ConstantMgr_PKG.COM_getScacCode_FNC()||PB.BKG_NO UCR_NO " ).append("\n"); 
		query.append("     , PB.N1ST_SHPR_NM SHPR_NM1" ).append("\n"); 
		query.append("     , PB.N2ND_SHPR_NM SHPR_NM2" ).append("\n"); 
		query.append("     , 'NY' OP_CD" ).append("\n"); 
		query.append("     , 'NY' SO_CD" ).append("\n"); 
		query.append("     , PB.POD_CD BKG_POD" ).append("\n"); 
		query.append("     , PB.N1ST_POD_CD POD_LOC1" ).append("\n"); 
		query.append("     , PB.N2ND_POD_CD POD_LOC2" ).append("\n"); 
		query.append("     , PB.N3RD_POD_CD POD_LOC3" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_PSA_BKG     PB  ," ).append("\n"); 
		query.append("       BKG_CSTMS_PSA_VVD    PV" ).append("\n"); 
		query.append("WHERE  PV.VSL_CD       =   PB.VSL_CD" ).append("\n"); 
		query.append("AND    PV.SKD_VOY_NO   =   PB.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    PV.SKD_DIR_CD   =   PB.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    PB.BKG_NO       =   @[bkg_no]" ).append("\n"); 
		query.append("AND    PB.BKG_SEQ      =   @[bkg_seq] - 1" ).append("\n"); 

	}
}