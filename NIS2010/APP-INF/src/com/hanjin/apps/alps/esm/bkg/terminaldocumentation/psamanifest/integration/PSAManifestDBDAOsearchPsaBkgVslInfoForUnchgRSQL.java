/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : PSAManifestDBDAOsearchPsaBkgVslInfoForUnchgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2017.03.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOsearchPsaBkgVslInfoForUnchgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [vvd_unchanged용]PSA BKG VSL Info를 조회하여 flat file로 만든다.
	  * </pre>
	  */
	public PSAManifestDBDAOsearchPsaBkgVslInfoForUnchgRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n"); 
		query.append("FileName : PSAManifestDBDAOsearchPsaBkgVslInfoForUnchgRSQL").append("\n"); 
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
		query.append("     , PB.PSA_IF_CD BKG_FI" ).append("\n"); 
		query.append("     , 'SMLM' || PB.BKG_NO UCR_NO" ).append("\n"); 
		query.append("     , PB.N1ST_SHPR_NM SHPR_NM1" ).append("\n"); 
		query.append("     , PB.N2ND_SHPR_NM SHPR_NM2" ).append("\n"); 
		query.append("     , 'SL' OP_CD" ).append("\n"); 
		query.append("     , 'SM' SO_CD" ).append("\n"); 
		query.append("     , PB.POD_CD BKG_POD" ).append("\n"); 
		query.append("     , BB.POD_NOD_CD BKG_YDCD_POD" ).append("\n"); 
		query.append("     , PB.N1ST_POD_CD POD_LOC1" ).append("\n"); 
		query.append("     ,  (SELECT MAX(POD_YD_CD ) " ).append("\n"); 
		query.append("          FROM BKG_VVD " ).append("\n"); 
		query.append("         WHERE POD_CD =PB.N1ST_POD_CD" ).append("\n"); 
		query.append("         AND BKG_NO=@[bkg_no]) POD_YDCD_LOC1" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("     , PB.N2ND_POD_CD POD_LOC2" ).append("\n"); 
		query.append("     , (SELECT MAX(POD_YD_CD)  " ).append("\n"); 
		query.append("          FROM BKG_VVD " ).append("\n"); 
		query.append("         WHERE POD_CD =PB.N2ND_POD_CD" ).append("\n"); 
		query.append("         AND BKG_NO=@[bkg_no]) POD_YDCD_LOC2" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     , PB.N3RD_POD_CD POD_LOC3" ).append("\n"); 
		query.append("     ,(SELECT POD_YD_CD  " ).append("\n"); 
		query.append("          FROM BKG_VVD " ).append("\n"); 
		query.append("         WHERE POD_CD =PB.N3RD_POD_CD" ).append("\n"); 
		query.append("         AND BKG_NO=@[bkg_no]) POD_YDCD_LOC3" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_PSA_BKG     PB  ," ).append("\n"); 
		query.append("        BKG_CSTMS_PSA_VVD    PV ," ).append("\n"); 
		query.append("		BKG_BOOKING          BB" ).append("\n"); 
		query.append("WHERE   PV.VSL_CD       =   PB.VSL_CD" ).append("\n"); 
		query.append("AND     PV.SKD_VOY_NO   =   PB.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     PV.SKD_DIR_CD   =   PB.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     PB.BKG_NO       =   BB.BKG_NO" ).append("\n"); 
		query.append("AND     PB.BKG_NO       =   @[bkg_no]" ).append("\n"); 
		query.append("AND     PB.BKG_SEQ      =   @[bkg_seq]" ).append("\n"); 

	}
}