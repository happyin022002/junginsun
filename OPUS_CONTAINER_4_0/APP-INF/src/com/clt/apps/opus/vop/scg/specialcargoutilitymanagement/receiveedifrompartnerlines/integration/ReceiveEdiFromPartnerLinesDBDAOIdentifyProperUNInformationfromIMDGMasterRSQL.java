/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ReceiveEdiFromPartnerLinesDBDAOIdentifyProperUNInformationfromIMDGMasterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveEdiFromPartnerLinesDBDAOIdentifyProperUNInformationfromIMDGMasterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IMDG Master 데이터에서 UN NO SEQ 및 EMS 데이터 찾기
	  * </pre>
	  */
	public ReceiveEdiFromPartnerLinesDBDAOIdentifyProperUNInformationfromIMDGMasterRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_tec_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_amdt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pck_grp_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prp_shp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration").append("\n"); 
		query.append("FileName : ReceiveEdiFromPartnerLinesDBDAOIdentifyProperUNInformationfromIMDGMasterRSQL").append("\n"); 
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
		query.append("SELECT    MAX(XX.MAPPING_RNK)                       					AS MAPPING_RNK" ).append("\n"); 
		query.append("	   ,  MAX(XX.IMDG_AMDT_NO)  										AS IMDG_AMDT_NO" ).append("\n"); 
		query.append("       ,  MAX(XX.IMDG_UN_NO)											AS IMDG_UN_NO" ).append("\n"); 
		query.append("       ,  MAX(XX.IMDG_UN_NO_SEQ)										AS IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("       ,  MAX(XX.PRP_SHP_NM)											AS PRP_SHP_NM" ).append("\n"); 
		query.append("	   ,  MAX(XX.IMDG_TEC_NM)                     						AS IMDG_TEC_NM" ).append("\n"); 
		query.append("       ,  MAX(XX.IMDG_PCK_GRP_CD_CTNT)									AS IMDG_PCK_GRP_CD_CTNT" ).append("\n"); 
		query.append("	   ,  MAX(XX.IMDG_COMP_GRP_CD)										AS IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("       ,  MAX(XX.EMS_NO)												AS EMS_NO" ).append("\n"); 
		query.append("       ,  MAX((DECODE(SRSK_LBL_RNK,'1',XX.IMDG_SUBS_RSK_LBL_CD,'')))	AS N1ST_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("       ,  MAX((DECODE(SRSK_LBL_RNK,'2',XX.IMDG_SUBS_RSK_LBL_CD,'')))	AS N2ND_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("       ,  MAX((DECODE(SRSK_LBL_RNK,'3',XX.IMDG_SUBS_RSK_LBL_CD,'')))	AS N3RD_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("       ,  MAX((DECODE(SRSK_LBL_RNK,'4',XX.IMDG_SUBS_RSK_LBL_CD,'')))	AS N4TH_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ,  MAX((DECODE(SRSK_LBL_RNK,'5',XX.IMDG_SUBS_RSK_LBL_CD,'')))	AS N5TH_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("       ,  MAX((DECODE(SRSK_LBL_RNK,'6',XX.IMDG_SUBS_RSK_LBL_CD,'')))	AS N6TH_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("       ,  MAX((DECODE(SRSK_LBL_RNK,'7',XX.IMDG_SUBS_RSK_LBL_CD,'')))	AS N7TH_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("       ,  MAX((DECODE(SRSK_LBL_RNK,'8',XX.IMDG_SUBS_RSK_LBL_CD,'')))	AS N8TH_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM      (" ).append("\n"); 
		query.append("          --===========================================================================================" ).append("\n"); 
		query.append("          SELECT    XX.IMDG_AMDT_NO" ).append("\n"); 
		query.append("                 ,  XX.IMDG_UN_NO" ).append("\n"); 
		query.append("                 ,  XX.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("                 ,  XX.PRP_SHP_NM" ).append("\n"); 
		query.append("				 ,  XX.IMDG_TEC_NM" ).append("\n"); 
		query.append("                 ,  XX.IMDG_PCK_GRP_CD_CTNT" ).append("\n"); 
		query.append("				 ,	XX.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("                 ,  XX.EMS_NO" ).append("\n"); 
		query.append("                 ,  YY.IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("                 ,  ROW_NUMBER() OVER (PARTITION BY YY.IMDG_UN_NO,YY.IMDG_UN_NO_SEQ ORDER BY YY.IMDG_SUBS_RSK_LBL_CD ASC) SRSK_LBL_RNK" ).append("\n"); 
		query.append("				 ,  XX.MAPPING_RNK" ).append("\n"); 
		query.append("          FROM      (" ).append("\n"); 
		query.append("          			---------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("					SELECT		*" ).append("\n"); 
		query.append("					FROM		(" ).append("\n"); 
		query.append("					---------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("					SELECT		*" ).append("\n"); 
		query.append("					FROM		(" ).append("\n"); 
		query.append("								---------------------------------------------------------------------------------" ).append("\n"); 
		query.append("          			SELECT    	X.IMDG_AMDT_NO" ).append("\n"); 
		query.append("                 			,  	X.IMDG_UN_NO" ).append("\n"); 
		query.append("                 			,  	X.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("                 			,  	X.PRP_SHP_NM" ).append("\n"); 
		query.append("							,	Y.IMDG_TEC_NM" ).append("\n"); 
		query.append("                 			,  	X.IMDG_PCK_GRP_CD						AS IMDG_PCK_GRP_CD_CTNT" ).append("\n"); 
		query.append("							,	X.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("                 			,  	X.IMDG_EMER_NO  						AS EMS_NO" ).append("\n"); 
		query.append("                 			,  	CASE 	WHEN X.PRP_SHP_NM       		= @[prp_shp_nm] AND NVL(Y.IMDG_TEC_NM,'*')	= NVL(@[imdg_tec_nm],'*') 				THEN '01'" ).append("\n"); 
		query.append("										WHEN @[imdg_tec_nm]				IS NOT NULL     AND @[imdg_tec_nm]			= Y.IMDG_TEC_NM							THEN '11'" ).append("\n"); 
		query.append("										WHEN @[imdg_tec_nm]				IS NOT NULL     AND UPPER(@[imdg_tec_nm])	= UPPER(Y.IMDG_TEC_NM)					THEN '12'" ).append("\n"); 
		query.append("										WHEN @[imdg_tec_nm]				IS NOT NULL     AND Y.IMDG_TEC_NM			IS NULL									THEN '13'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("										WHEN @[imdg_tec_nm]				IS NULL			AND X.PRP_SHP_NM       		= @[prp_shp_nm]   						THEN '21'" ).append("\n"); 
		query.append("                         				WHEN @[imdg_tec_nm]				IS NULL			AND	LTRIM(RTRIM(X.PRP_SHP_NM))  LIKE LTRIM(RTRIM(@[prp_shp_nm])) 	THEN '22'" ).append("\n"); 
		query.append("                         				WHEN @[imdg_tec_nm]				IS NULL			AND	@[prp_shp_nm]       		LIKE '%'||X.PRP_SHP_NM||'%' 		THEN '23'" ).append("\n"); 
		query.append("										ELSE																												     NULL" ).append("\n"); 
		query.append("                    			END  	AS MAPPING_RNK" ).append("\n"); 
		query.append("          			FROM      	SCG_IMDG_UN_NO    						X" ).append("\n"); 
		query.append("							,	SCG_IMDG_UN_NO_ORG_RACT					Y	" ).append("\n"); 
		query.append("          			WHERE     	1 = 1" ).append("\n"); 
		query.append("					AND			X.IMDG_UN_NO							= Y.IMDG_UN_NO					(+)" ).append("\n"); 
		query.append("					AND			X.IMDG_UN_NO_SEQ						= Y.IMDG_UN_NO_SEQ				(+)" ).append("\n"); 
		query.append("					AND       	NVL(X.IMDG_AMDT_NO,'*')       			= NVL(@[imdg_amdt_no],'*')" ).append("\n"); 
		query.append("					AND			X.IMDG_UN_NO      						= @[imdg_un_no_ctnt]" ).append("\n"); 
		query.append("          			AND       	DECODE(X.IMDG_PCK_GRP_CD,NULL,'*','I','1','II','2','III','3',X.IMDG_PCK_GRP_CD)" ).append("\n"); 
		query.append("                                      									= DECODE(@[imdg_pck_grp_cd_ctnt],NULL,'*','I','1','II','2','III','3',@[imdg_pck_grp_cd_ctnt])" ).append("\n"); 
		query.append("          			" ).append("\n"); 
		query.append("					--:2015-08-28:--AND       	[prp_shp_nm]       					LIKE '%'||X.PRP_SHP_NM||'%'" ).append("\n"); 
		query.append("          			--AND       	LTRIM(RTRIM([prp_shp_nm]))				= X.PRP_SHP_NM" ).append("\n"); 
		query.append("					--:2016-10-11: PSN 공백 제거 " ).append("\n"); 
		query.append("          			--AND       	REPLACE([prp_shp_nm],' ','')				= REPLACE(X.PRP_SHP_NM, ' ','')" ).append("\n"); 
		query.append(" 					--:2016-10-19: PSN 쉼표,마침표, 공백 제거 후 문자열 비교 " ).append("\n"); 
		query.append("					AND REPLACE(REPLACE(REPLACE(@[prp_shp_nm], ' ', ''), '.', ''), ',', '') = REPLACE(REPLACE(REPLACE(X.PRP_SHP_NM, ' ', ''), '.', ''), ',', '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		  			AND			NVL(X.CFR_FLG,'N')						= NVL(@[cfr_flg],'N')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					AND			X.IMDG_CLSS_CD    						= @[imdg_clss_cd_ctnt]		/* ADDING ON 11st SEP 2015 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					--:2015-08-18:--AND			NVL([imdg_tec_nm],'*')	= NVL(Y.IMDG_TEC_NM,'*')" ).append("\n"); 
		query.append("								---------------------------------------------------------------------------------" ).append("\n"); 
		query.append("								) X" ).append("\n"); 
		query.append("					WHERE		X.MAPPING_RNK							IS NOT NULL" ).append("\n"); 
		query.append("					ORDER BY	X.MAPPING_RNK							ASC" ).append("\n"); 
		query.append("							,	X.IMDG_UN_NO_SEQ						ASC" ).append("\n"); 
		query.append("								) Y" ).append("\n"); 
		query.append("					WHERE		ROWNUM									= 1" ).append("\n"); 
		query.append("                    ---------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("                    ) XX" ).append("\n"); 
		query.append("                ,   SCG_IMDG_SUBS_RSK_LBL   							YY" ).append("\n"); 
		query.append("          WHERE     XX.IMDG_UN_NO           							= YY.IMDG_UN_NO       			(+)" ).append("\n"); 
		query.append("          AND       XX.IMDG_UN_NO_SEQ       							= YY.IMDG_UN_NO_SEQ   			(+)	" ).append("\n"); 
		query.append("          --===========================================================================================" ).append("\n"); 
		query.append("          ) XX" ).append("\n"); 
		query.append("GROUP BY  XX.IMDG_AMDT_NO" ).append("\n"); 
		query.append("       ,  XX.IMDG_UN_NO" ).append("\n"); 
		query.append("       ,  XX.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("       ,  XX.PRP_SHP_NM" ).append("\n"); 
		query.append("       ,  XX.IMDG_PCK_GRP_CD_CTNT" ).append("\n"); 
		query.append("       ,  XX.EMS_NO" ).append("\n"); 

	}
}