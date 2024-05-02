/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOmodifyCBFPartnerEDIUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOmodifyCBFPartnerEDIUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Partner edi 수정
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOmodifyCBFPartnerEDIUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iso_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOmodifyCBFPartnerEDIUSQL").append("\n"); 
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
		query.append("UPDATE OPF_PRNR_EDI_CGO_BKG_FCAST SET POD_CD            = @[pod_cd]," ).append("\n"); 
		query.append("                                      CNTR_TPSZ_CD      = @[cntr_tpsz_cd]," ).append("\n"); 
		query.append("                                      CRR_CD            = @[crr_cd]," ).append("\n"); 
		query.append("                                      VSL_CD            = substr(@[vvd],1,4)," ).append("\n"); 
		query.append("                                      SKD_VOY_NO        = substr(@[vvd],5,4)," ).append("\n"); 
		query.append("                                      SKD_DIR_CD        = substr(@[vvd],9,1)," ).append("\n"); 
		query.append("                                      YD_CD             = @[yd_cd]," ).append("\n"); 
		query.append("                                      UPD_USR_ID        = @[cre_usr_id]," ).append("\n"); 
		query.append("                                      UPD_DT            = SYSDATE," ).append("\n"); 
		query.append("                                      POL_CLPT_IND_SEQ  = ( SELECT NVL(MIN(CLPT_IND_SEQ),1)" ).append("\n"); 
		query.append("                                                              FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                             WHERE VSL_CD     = substr(@[vvd],1,4)" ).append("\n"); 
		query.append("                                                               AND SKD_VOY_NO = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("                                                               AND SKD_DIR_CD = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("                                                               AND YD_CD      = @[yd_cd]" ).append("\n"); 
		query.append("                                                               AND TURN_PORT_IND_CD IN ('Y','N') )" ).append("\n"); 
		query.append("                                WHERE UPLD_DT      IS NULL" ).append("\n"); 
		query.append("                                  AND EDI_RCV_DT      = @[edi_rcv_dt]" ).append("\n"); 
		query.append("                                  AND EDI_SND_ID      = @[edi_snd_id]" ).append("\n"); 
		query.append("                                  AND EDI_POL_YD_CD   = @[edi_pol_yd_cd]" ).append("\n"); 
		query.append("                                  AND CRR_NM          = @[crr_nm]" ).append("\n"); 
		query.append("                                  AND EDI_VSL_NM||CBF_RMK      = @[edi_vsl_nm]" ).append("\n"); 
		query.append("                                  AND EDI_POD_CD               = @[edi_pod_cd]" ).append("\n"); 
		query.append("                                  AND NVL(ISO_CNTR_TPSZ_CD,'XX') = NVL(@[iso_cntr_tpsz_cd],'XX')" ).append("\n"); 

	}
}