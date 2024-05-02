/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : IndiaCustomsTransmissionDBDAOsearchContainerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.07
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2011.07.07 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.india.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndiaCustomsTransmissionDBDAOsearchContainerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * container list대상 조회하는 오퍼레이션
	  * </pre>
	  */
	public IndiaCustomsTransmissionDBDAOsearchContainerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("line_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.india.integration").append("\n"); 
		query.append("FileName : IndiaCustomsTransmissionDBDAOsearchContainerListRSQL").append("\n"); 
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
		query.append("SELECT  BCIC.IDA_STWG_NO" ).append("\n"); 
		query.append("       ,BCIC.CNTR_NO " ).append("\n"); 
		query.append("       ,TO_CHAR(BC.CNTR_WGT / 1000) CNTR_WGT" ).append("\n"); 
		query.append("       , DECODE(BCIB.POD_CD, 'INMAA', DECODE(BC.CNTR_TPSZ_CD, 'D2', '2210'," ).append("\n"); 
		query.append("                                				      		  'D4', '4210'," ).append("\n"); 
		query.append("                                  				      		  'D5', '4410'," ).append("\n"); 
		query.append("                                  				      		  'D7', '9410'," ).append("\n"); 
		query.append("                                  				      		  'R2', '2232'," ).append("\n"); 
		query.append("                                  				      		  'R5', '4432'," ).append("\n"); 
		query.append("                                  				      		  'O2', '2251'," ).append("\n"); 
		query.append("                                  				      		  'O4', '4251'," ).append("\n"); 
		query.append("                                  				      		  'F2', '2260'," ).append("\n"); 
		query.append("                                  				      		  'F4', '4260'," ).append("\n"); 
		query.append("                                  				      		  'T2', '2270'," ).append("\n"); 
		query.append("                                                              'R9', '5500'" ).append("\n"); 
		query.append("                                  				      		   )" ).append("\n"); 
		query.append("                                    , DECODE(BC.CNTR_TPSZ_CD, 'D2', '2000'," ).append("\n"); 
		query.append("                                  				      		  'D4', '4000'," ).append("\n"); 
		query.append("                                  				      		  'D5', '4200'," ).append("\n"); 
		query.append("                                  				      		  'D7', '9510'," ).append("\n"); 
		query.append("                                  				      		  'R2', '2230'," ).append("\n"); 
		query.append("                                  				      		  'R5', '4230'," ).append("\n"); 
		query.append("                                  				      		  'O2', '2251'," ).append("\n"); 
		query.append("                                  				      		  'O4', '4251'," ).append("\n"); 
		query.append("                                  				      		  'F2', '2060'," ).append("\n"); 
		query.append("                                  				      		  'F4', '4060'," ).append("\n"); 
		query.append("                                  				      		  'T2', '2070'," ).append("\n"); 
		query.append("                                                              'R9', '5500'" ).append("\n"); 
		query.append("                                  				      		   )" ).append("\n"); 
		query.append("                  )  CNTR_TPSZ_VALUE" ).append("\n"); 
		query.append("        ,DECODE(BCIB.BL_NO, BCIB.NVOCC_REF_NO, DECODE(BC.CNMV_STS_CD, 'MT', 'E', 'F'), DECODE(BC.CNMV_STS_CD, 'MT', 'E', 'L')) CNMV_STS_CD" ).append("\n"); 
		query.append("        ,BDC.IMDG_CLSS_CD IMDG_CLSS_CD" ).append("\n"); 
		query.append("        ,SUBSTR(BCIB.POL_CD, 3, 3) POL_CD_LEN3" ).append("\n"); 
		query.append("        ,BCIB.IAL_RGN_CD" ).append("\n"); 
		query.append("        ,DECODE(BCIB.BL_DECL_TP_CD, 'LC', 'I', 'TI', 'I', 'TS', 'T', 'R') BL_DECL_TP_CD" ).append("\n"); 
		query.append("        ,DECODE(BCIB.IDA_TRSP_CD, 'R', 'T', 'T', 'R', 'S', 'V', 'T') IDA_TRSP_CD" ).append("\n"); 
		query.append("        ,@[line_cd] line_cd" ).append("\n"); 
		query.append("        ,BCIC.RC_FLG RC_FLG" ).append("\n"); 
		query.append("        ,DECODE(BCIC.RC_FLG, 'Y', SUBSTR(BCIC.SPCL_CGO_DESC, 1, 6)) SPCL_CGO_DESC    " ).append("\n"); 
		query.append("FROM  BKG_CSTMS_IDA_VSL    BCIV " ).append("\n"); 
		query.append("     ,BKG_CSTMS_IDA_BL     BCIB " ).append("\n"); 
		query.append("     ,BKG_DG_CGO           BDC  " ).append("\n"); 
		query.append("     ,BKG_CSTMS_IDA_CNTR   BCIC " ).append("\n"); 
		query.append("     ,BKG_CONTAINER        BC  " ).append("\n"); 
		query.append("     ,BKG_BOOKING          BB  " ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND   BCIV.VSL_CD       =   BCIB.VSL_CD" ).append("\n"); 
		query.append("AND   BCIV.SKD_VOY_NO   =   BCIB.SKD_VOY_NO " ).append("\n"); 
		query.append("AND   BCIV.SKD_DIR_CD   =   BCIB.SKD_DIR_CD" ).append("\n"); 
		query.append("AND   BCIV.POD_CD       =   BCIB.POD_CD" ).append("\n"); 
		query.append("AND   BCIB.BL_NO        =   BB.BL_NO" ).append("\n"); 
		query.append("AND   BCIB.BL_NO        =   BCIC.BL_NO" ).append("\n"); 
		query.append("AND   BC.CNTR_NO        =   BCIC.CNTR_NO" ).append("\n"); 
		query.append("AND   BCIC.POD_CD       =   BCIB.POD_CD" ).append("\n"); 
		query.append("AND	  BB.BKG_STS_CD		<>  'X'" ).append("\n"); 
		query.append("AND   BB.BKG_CGO_TP_CD  <> 'P'    " ).append("\n"); 
		query.append("AND   BB.BKG_NO         =   BC.BKG_NO" ).append("\n"); 
		query.append("AND   BDC.BKG_NO(+)     =   BB.BKG_NO" ).append("\n"); 
		query.append("AND   BCIC.VSL_CD       =   SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND   BCIC.SKD_VOY_NO   =   SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND   BCIC.SKD_DIR_CD   =   SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append("AND   BCIC.POD_CD       =   @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("AND   BCIC.POL_CD    LIKE   NVL(@[pol_cd], '') || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}