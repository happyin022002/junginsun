/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RussiaCustomsTransmissionDBDAOsearchCncusCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RussiaCustomsTransmissionDBDAOsearchCncusCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCncusCntr
	  * </pre>
	  */
	public RussiaCustomsTransmissionDBDAOsearchCncusCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.integration").append("\n"); 
		query.append("FileName : RussiaCustomsTransmissionDBDAOsearchCncusCntrRSQL").append("\n"); 
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
		query.append("SELECT  BKG_CNTR.BKG_NO," ).append("\n"); 
		query.append("        BKG_CNTR.CNTR_NO," ).append("\n"); 
		query.append("        BKG_JOIN_FNC (CURSOR(" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                        SELECT CNTR_SEAL_NO " ).append("\n"); 
		query.append("                          FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("                         WHERE BKG_NO = BKG_CNTR.BKG_NO" ).append("\n"); 
		query.append("                          AND  CNTR_NO = BKG_CNTR.CNTR_NO" ).append("\n"); 
		query.append("                          AND CNTR_SEAL_SEQ > 0" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                 ),'@') CNTR_SEAL_NO" ).append("\n"); 
		query.append("            ,ISO.CNTR_TPSZ_ISO_CD" ).append("\n"); 
		query.append("            ,BKG.BKG_CGO_TP_CD FULL_MTY_CD" ).append("\n"); 
		query.append("            ,BKG_CNTR.CNTR_WGT" ).append("\n"); 
		query.append("            ,DECODE(NVL(SPEC.TARE_WGT,0),0," ).append("\n"); 
		query.append("                      DECODE(NVL(ISO.CNTR_TPSZ_TARE_WGT,0),0," ).append("\n"); 
		query.append("                      DECODE(CNTR.CNTR_TPSZ_CD, 'T2', 3600, 'T4', 5200, 0),ISO.CNTR_TPSZ_TARE_WGT), SPEC.TARE_WGT  ) TARE_WGT" ).append("\n"); 
		query.append("            ,SCA.OVR_FWRD_LEN OVR_DIM_FNT_LEN" ).append("\n"); 
		query.append("            ,SCA.OVR_BKWD_LEN OVR_DIM_REAR_LEN " ).append("\n"); 
		query.append("            ,SCA.OVR_HGT OVR_HGT" ).append("\n"); 
		query.append("            ,SCA.OVR_LF_LEN OVR_DIM_LF_LEN" ).append("\n"); 
		query.append("            ,SCA.OVR_RT_LEN OVR_DIM_RT_LEN" ).append("\n"); 
		query.append("            ,BKG_CNTR.MEAS_QTY  CNTR_MEAS_QTY" ).append("\n"); 
		query.append("            ,BKG_CNTR.PCK_QTY  PKG_QTY" ).append("\n"); 
		query.append("FROM   BKG_CONTAINER BKG_CNTR," ).append("\n"); 
		query.append("        BKG_AWK_CGO  SCA," ).append("\n"); 
		query.append("        MST_CONTAINER   CNTR," ).append("\n"); 
		query.append("                     MST_CNTR_SPEC   SPEC," ).append("\n"); 
		query.append("        MDM_CNTR_TP_SZ   ISO," ).append("\n"); 
		query.append("        BKG_BOOKING BKG" ).append("\n"); 
		query.append("WHERE  BKG_CNTR.BKG_NO                              =       @[bl_no]" ).append("\n"); 
		query.append("AND         BKG_CNTR.BKG_NO                         =        SCA.BKG_NO(+)" ).append("\n"); 
		query.append("AND         BKG_CNTR.CNTR_NO                       =        SCA.CNTR_NO(+)" ).append("\n"); 
		query.append("AND                BKG_CNTR.CNTR_NO                            =        CNTR.CNTR_NO(+)" ).append("\n"); 
		query.append("AND     CNTR.CNTR_SPEC_NO     =  SPEC.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("AND     CNTR.CNTR_TPSZ_CD     =  ISO.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("AND     BKG_CNTR.BKG_NO = BKG.BKG_NO" ).append("\n"); 

	}
}