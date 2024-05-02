/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PanamaCustomsTransmissionDBDAOsearchMctForBasicInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.16
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.01.16 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM MINJUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PanamaCustomsTransmissionDBDAOsearchMctForBasicInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMctForBasicInfo
	  * </pre>
	  */
	public PanamaCustomsTransmissionDBDAOsearchMctForBasicInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pnm_org_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mvmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pnm_dest_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dgpackage",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pnm_vsl_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.integration").append("\n"); 
		query.append("FileName : PanamaCustomsTransmissionDBDAOsearchMctForBasicInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	@[vst_no] VST_NO," ).append("\n"); 
		query.append("	@[vvd_cd] VVD_CD," ).append("\n"); 
		query.append("	@[pnm_org_cd] PNM_ORG_CD," ).append("\n"); 
		query.append("	@[pnm_dest_cd] PNM_DEST_CD," ).append("\n"); 
		query.append("	'' MCARGO," ).append("\n"); 
		query.append("	@[pnm_vsl_opr_cd] PNM_VSL_OPR_CD," ).append("\n"); 
		query.append("	'Y' CARGO," ).append("\n"); 
		query.append("	'N' MTTANKS,    " ).append("\n"); 
		query.append("	'N' DGBULK,  " ).append("\n"); 
		query.append("	@[dgpackage] DGPACKAGE," ).append("\n"); 
		query.append("	@[mvmt_seq] MVMT_SEQ," ).append("\n"); 
		query.append("	LTRIM(TO_CHAR(BKG_CSTM_EDI_SEQ.NEXTVAL,'000009'),' ') HEADER_SEQ" ).append("\n"); 
		query.append("   ,LANE.VSL_SLAN_CD" ).append("\n"); 
		query.append("   ,LANE.VSL_SLAN_NM" ).append("\n"); 
		query.append("   ,VVD.POL_CD " ).append("\n"); 
		query.append("   ,VVD.POD_CD " ).append("\n"); 
		query.append("  FROM BKG_CSTMS_PNM_VVD VVD" ).append("\n"); 
		query.append("      ,MDM_VSL_SVC_LANE  LANE" ).append("\n"); 
		query.append(" WHERE VVD.SLAN_CD    = LANE.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("   AND VVD.VSL_CD     = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("   AND VVD.VST_NO     = @[vst_no]" ).append("\n"); 

	}
}