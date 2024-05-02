/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchCncusTmlVvdInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOsearchCncusTmlVvdInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCncusTmlVvdInfo
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchCncusTmlVvdInfoRSQL(){
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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n"); 
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchCncusTmlVvdInfoRSQL").append("\n"); 
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
		query.append("WITH SND_LOG AS (" ).append("\n"); 
		query.append("SELECT  * FROM (" ).append("\n"); 
		query.append("SELECT  DENSE_RANK() OVER(ORDER BY SLOG.MF_SND_DT DESC) AS RNUM," ).append("\n"); 
		query.append("SLOG.MF_SND_DT," ).append("\n"); 
		query.append("SLOG.EDI_REF_ID," ).append("\n"); 
		query.append("SLOG.VSL_CD," ).append("\n"); 
		query.append("SLOG.SKD_VOY_NO," ).append("\n"); 
		query.append("SLOG.SKD_DIR_CD" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_CHN_SND_LOG SLOG" ).append("\n"); 
		query.append("WHERE   SLOG.CHN_MF_SND_IND_CD  = 'T'" ).append("\n"); 
		query.append("AND     SLOG.VSL_CD 	 = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND     SLOG.SKD_VOY_NO  = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND     SLOG.SKD_DIR_CD  = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND     SLOG.MF_SND_DT IS NOT NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE   RNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  SUBSTR(VVD, 1, 4) AS VSL_CD," ).append("\n"); 
		query.append("SUBSTR(VVD, 5, 4) AS SKD_VOY_NO," ).append("\n"); 
		query.append("SUBSTR(VVD, 9, 1) AS SKD_DIR_CD," ).append("\n"); 
		query.append("V.CALL_SGN_NO AS VSL_CALL_SGN_PORT_LOC_CD," ).append("\n"); 
		query.append("PRE_PORT AS PRE_CLPT_CD," ).append("\n"); 
		query.append("NXT_PORT AS NXT_CLPT_CD," ).append("\n"); 
		query.append("TO_CHAR(ETA, 'YYYY-MM-DD HH24:MI') AS ETA_DT," ).append("\n"); 
		query.append("TO_CHAR(ETD, 'YYYY-MM-DD HH24:MI') AS ETD_DT," ).append("\n"); 
		query.append("V.VSL_ENG_NM AS VSL_NM," ).append("\n"); 
		query.append("TO_CHAR(SND_LOG.MF_SND_DT, 'YYYY-MM-DD HH24:MI') MF_SND_DT" ).append("\n"); 
		query.append("FROM	MDM_VSL_CNTR V," ).append("\n"); 
		query.append("SND_LOG," ).append("\n"); 
		query.append("(	SELECT	VPS.VSL_CD," ).append("\n"); 
		query.append("VPS.SKD_VOY_NO," ).append("\n"); 
		query.append("VPS.SKD_DIR_CD," ).append("\n"); 
		query.append("VPS.VSL_CD||VPS.SKD_VOY_NO||VPS.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("VPS.VPS_PORT_CD PORT," ).append("\n"); 
		query.append("VPS2.VPS_PORT_CD PRE_PORT," ).append("\n"); 
		query.append("VPS.VPS_ETA_DT ETA," ).append("\n"); 
		query.append("VPS3.VPS_PORT_CD NXT_PORT," ).append("\n"); 
		query.append("VPS.VPS_ETD_DT ETD" ).append("\n"); 
		query.append("FROM	VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD VPS2," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD VPS3" ).append("\n"); 
		query.append("WHERE	VPS.VSL_CD				=	SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND	VPS.SKD_VOY_NO			    =	SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND	VPS.SKD_DIR_CD				=	SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND	VPS.VPS_PORT_CD				=	@[loc_cd]" ).append("\n"); 
		query.append("AND	NVL(VPS.SKD_CNG_STS_CD,' ')		<>	'S'" ).append("\n"); 
		query.append("AND	(VPS.CLPT_IND_SEQ			=	'1' OR VPS.CLPT_IND_SEQ = '2')" ).append("\n"); 
		query.append("AND	VPS.VSL_CD				    =	VPS2.VSL_CD(+)" ).append("\n"); 
		query.append("AND	VPS.SKD_VOY_NO			    =	VPS2.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND	VPS.SKD_DIR_CD				=	VPS2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND	VPS.CLPT_SEQ - 1		    =	VPS2.CLPT_SEQ(+)" ).append("\n"); 
		query.append("AND	VPS.VSL_CD				    =	VPS3.VSL_CD(+)" ).append("\n"); 
		query.append("AND	VPS.SKD_VOY_NO			    =	VPS3.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND	VPS.SKD_DIR_CD				=	VPS3.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND	VPS.CLPT_SEQ + 1		    =	VPS3.CLPT_SEQ(+)" ).append("\n"); 
		query.append("ORDER BY VPS.CLPT_IND_SEQ DESC" ).append("\n"); 
		query.append(") VSL" ).append("\n"); 
		query.append("WHERE	VSL.VSL_CD		= V.VSL_CD" ).append("\n"); 
		query.append("AND     VSL.VSL_CD		= SND_LOG.VSL_CD(+)" ).append("\n"); 
		query.append("AND     VSL.SKD_VOY_NO 	= SND_LOG.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND     VSL.SKD_DIR_CD 	= SND_LOG.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND	ROWNUM	= 1" ).append("\n"); 

	}
}