/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOScgMailTampletVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAOScgMailTampletVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Mail Preview 의 Tamplet 을 조회한다.
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOScgMailTampletVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_snd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOScgMailTampletVORSQL").append("\n"); 
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
		query.append("SELECT DECODE(NVL(TMP.EML_SND_USR_ID,''),'','I','U') ibflag" ).append("\n"); 
		query.append("	 , NVL(TMP.EML_SND_USR_ID,USR.USR_ID) EML_SND_USR_ID" ).append("\n"); 
		query.append("     , NVL(TMP.SPCL_CGO_CD,DUM.TP) SPCL_CGO_CD" ).append("\n"); 
		query.append("     , NVL(TMP.HDR_CTNT,'') HDR_CTNT" ).append("\n"); 
		query.append("     , NVL(TMP.FTR_CTNT,CONCAT(DUM.FTR_CTNT," ).append("\n"); 
		query.append("                        CONCAT(USR.USR_NM," ).append("\n"); 
		query.append("                        CONCAT(CHR(13)||USR.JB_ENG_NM," ).append("\n"); 
		query.append("                        CONCAT(CHR(13)||'Tel              : '||USR.MPHN_NO," ).append("\n"); 
		query.append("                        CONCAT(CHR(13)||'e-mail           : ',USR.USR_EML)))))) FTR_CTNT" ).append("\n"); 
		query.append("     , NVL(TMP.AUTO_EML_FLG,DUM.AUTO_EML_FLG) AUTO_EML_FLG" ).append("\n"); 
		query.append("     , TMP.CRE_USR_ID" ).append("\n"); 
		query.append("     , TMP.CRE_DT" ).append("\n"); 
		query.append("     , TMP.UPD_USR_ID" ).append("\n"); 
		query.append("     , TMP.UPD_DT" ).append("\n"); 
		query.append("  FROM COM_USER      USR" ).append("\n"); 
		query.append("     , SCG_EML_TMPLT TMP" ).append("\n"); 
		query.append("     , (SELECT LEVEL LVL" ).append("\n"); 
		query.append("             , DECODE(LEVEL,1,'DG',2,'AK',3,'BB',4,'RF','') TP" ).append("\n"); 
		query.append("             , CASE WHEN LEVEL=1 THEN 'Good day!'||CHR(13)||'Please your approval:'" ).append("\n"); 
		query.append("                    WHEN LEVEL=2 THEN 'Good day!'||CHR(13)||'Thanks for reverting with acceptance and slot loss for the below awkward  request.'" ).append("\n"); 
		query.append("                    WHEN LEVEL=3 THEN 'Good day!'||CHR(13)||'Thanks for reverting with acceptance and slot loss for the below break-bulk request.'" ).append("\n"); 
		query.append("                    ELSE 'Good day!'||CHR(13)||'Please your approval:'" ).append("\n"); 
		query.append("               END HDR_CTNT" ).append("\n"); 
		query.append("             , 'Best Regards'||CHR(13) FTR_CTNT" ).append("\n"); 
		query.append("             , 'N' AUTO_EML_FLG" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("        CONNECT BY LEVEL <= 4) DUM" ).append("\n"); 
		query.append(" WHERE USR.USR_ID = @[eml_snd_usr_id]" ).append("\n"); 
		query.append("   AND USR.USR_ID = TMP.EML_SND_USR_ID(+)" ).append("\n"); 
		query.append("   AND NVL(TMP.SPCL_CGO_CD,DUM.TP) = DUM.TP" ).append("\n"); 
		query.append(" ORDER BY DUM.LVL" ).append("\n"); 

	}
}