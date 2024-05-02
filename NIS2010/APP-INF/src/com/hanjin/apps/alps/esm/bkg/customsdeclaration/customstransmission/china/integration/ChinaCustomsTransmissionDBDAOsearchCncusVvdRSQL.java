/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchCncusVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.26 
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

public class ChinaCustomsTransmissionDBDAOsearchCncusVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChinaCncusVvdVO
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchCncusVvdRSQL(){
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
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n"); 
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchCncusVvdRSQL").append("\n"); 
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
		query.append("SELECT   SV.VSL_NM 				AS VSLFULLNAME	/*	VSL NM			 */" ).append("\n"); 
		query.append("         ,CASE WHEN @[trans_mode] = 'O' OR @[trans_mode] = 'D' THEN" ).append("\n"); 
		query.append("                    CASE WHEN CV.IB_VSL_NM is not null THEN  CV.IB_VSL_NM " ).append("\n"); 
		query.append("                         ELSE SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                         END" ).append("\n"); 
		query.append("              ELSE" ).append("\n"); 
		query.append("                    CASE WHEN CV.OB_VSL_NM is not null THEN  CV.OB_VSL_NM " ).append("\n"); 
		query.append("                         ELSE SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                         END                    " ).append("\n"); 
		query.append("              END AS VSLCD		/*	VSLCD			 */              " ).append("\n"); 
		query.append("         ,CASE WHEN @[trans_mode] = 'O' OR @[trans_mode] = 'D' THEN" ).append("\n"); 
		query.append("                    CASE WHEN CV.IB_SKD_VOY_NO is not null THEN  CV.IB_SKD_VOY_NO " ).append("\n"); 
		query.append("                         ELSE SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                         END" ).append("\n"); 
		query.append("              ELSE" ).append("\n"); 
		query.append("                    CASE WHEN CV.OB_SKD_VOY_NO is not null THEN  CV.OB_SKD_VOY_NO " ).append("\n"); 
		query.append("                         ELSE SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                         END                    " ).append("\n"); 
		query.append("              END AS VSLVOY		/*	VSLVOY			 */              " ).append("\n"); 
		query.append("         ,CASE WHEN @[trans_mode] = 'O' OR @[trans_mode] = 'D' THEN" ).append("\n"); 
		query.append("                    CASE WHEN CV.IB_SKD_DIR_NM is not null THEN  CV.IB_SKD_DIR_NM " ).append("\n"); 
		query.append("                         ELSE SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                         END" ).append("\n"); 
		query.append("              ELSE" ).append("\n"); 
		query.append("                    CASE WHEN CV.OB_SKD_DIR_NM is not null THEN  CV.OB_SKD_DIR_NM " ).append("\n"); 
		query.append("                         ELSE SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                         END                    " ).append("\n"); 
		query.append("              END  AS VSLDIR		/*	VSLDIR			 */       " ).append("\n"); 
		query.append("        ,SV.CALL_SGN_NO AS CALLSIGN	    	/*	CALL SIGN		 */" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, 'CNSHA'), 'YYYYMMDDHH24MISS') AS SENDDATE 	/*	Send Date & Time */	        " ).append("\n"); 
		query.append("        ,'REP_PERSON'			AS REP_PERSON    " ).append("\n"); 
		query.append("        ,SV.PORT_CD				AS POL		        " ).append("\n"); 
		query.append("        ,L3.LOC_NM				AS POLNAME		        " ).append("\n"); 
		query.append("        ,TO_CHAR(SV.ETD_DT, 'YYYYMMDDHH24MI')	AS POL_ETD " ).append("\n"); 
		query.append("        ,SV.PRE_CLPT_CD			AS PPORT			/*	PRE PORT		*/" ).append("\n"); 
		query.append("        ,L1.LOC_NM				AS PPORTNAME    	/*	PRE PORT NM		*/" ).append("\n"); 
		query.append("        ,TRIM(SV.NXT_CLPT_CD) 	AS NPORT        	/*	NPORT			*/" ).append("\n"); 
		query.append("        ,L2.LOC_NM				AS NPORTNAME    	/*	NPORT NAME		*/" ).append("\n"); 
		query.append("        ,TO_CHAR(SV.ETA_DT, 'YYYYMMDD') AS ETA	    /*	ETA			    */" ).append("\n"); 
		query.append("        ,TO_CHAR(SV.ETD_DT, 'YYYYMMDD') AS ETD	    /*	ETD			    */" ).append("\n"); 
		query.append("        ,NVL(SV.LLOYD_NO,'	')	AS IMO_NO      		/*	IMO NUMBER		*/" ).append("\n"); 
		query.append("        ,SV.SLAN_CD				AS LANE        		/*	LANE CODE		*/" ).append("\n"); 
		query.append("FROM	BKG_CSTMS_CHN_VVD SV," ).append("\n"); 
		query.append("    	MDM_LOCATION L1, " ).append("\n"); 
		query.append("    	MDM_LOCATION L2," ).append("\n"); 
		query.append("    	MDM_LOCATION L3, " ).append("\n"); 
		query.append("    	BKG_CSTMS_CHN_CORR_VVD CV" ).append("\n"); 
		query.append("WHERE	SV.VSL_CD		=	SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND	    SV.SKD_VOY_NO	=	SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND	    SV.SKD_DIR_CD   =	SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND	    SV.PORT_CD		=	@[pol]" ).append("\n"); 
		query.append("and     SV.VSL_CD		=	CV.VSL_CD(+)" ).append("\n"); 
		query.append("AND	    SV.SKD_VOY_NO	=	CV.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND	    SV.SKD_DIR_CD   =	CV.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("--AND	    SV.PORT_CD		=	CV.PORT_CD(+)" ).append("\n"); 
		query.append("AND     SV.CHN_MF_SND_IND_CD = @[trans_mode]" ).append("\n"); 
		query.append("AND	    L1.LOC_CD(+)	=	SV.PRE_CLPT_CD" ).append("\n"); 
		query.append("AND	    L2.LOC_CD(+)	=	SV.NXT_CLPT_CD" ).append("\n"); 
		query.append("AND	    L3.LOC_CD		=	SV.PORT_CD" ).append("\n"); 
		query.append("AND	    ROWNUM			=	1" ).append("\n"); 

	}
}