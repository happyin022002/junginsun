/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFModifyWgtGroupSummaryUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.01 
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

public class OwnContainerBookingForecastMgtDBDAOCBFModifyWgtGroupSummaryUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * weight group의 수량 변경
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFModifyWgtGroupSummaryUSQL(){
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
		params.put("f_45_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_40_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_40h_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blck_stwg_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_20_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFModifyWgtGroupSummaryUSQL").append("\n"); 
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
		query.append("MERGE INTO OPF_CGO_BKG_FCAST_WGT_GRP_SMRY A" ).append("\n"); 
		query.append("      USING DUAL" ).append("\n"); 
		query.append("      ON (      A.VSL_CD     = substr(@[vvd],1,4)" ).append("\n"); 
		query.append("                                      AND A.SKD_VOY_NO = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("                                      AND A.SKD_DIR_CD = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("                                      AND A.YD_CD||POL_CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("                                      AND A.CRR_CD       = @[crr_cd]" ).append("\n"); 
		query.append("                                      AND A.POD_CD       = @[pod_cd]" ).append("\n"); 
		query.append("                                      AND A.BLCK_STWG_CD = @[blck_stwg_cd]" ).append("\n"); 
		query.append("                                      AND A.CNTR_WGT_GRP_CD = DECODE(@[seq],'1','X','2','H','3','M','4','L','5','E','6','E')" ).append("\n"); 
		query.append("                                      #if (${col} == '1') " ).append("\n"); 
		query.append("                                      AND A.CNTR_SZ_CD    = '2'" ).append("\n"); 
		query.append("                                      #end" ).append("\n"); 
		query.append("                                      #if (${col} == '2') " ).append("\n"); 
		query.append("                                      AND A.CNTR_SZ_CD    = '4'" ).append("\n"); 
		query.append("                                      #end" ).append("\n"); 
		query.append("                                      #if (${col} == '3') " ).append("\n"); 
		query.append("                                      AND A.CNTR_SZ_CD    = '5'" ).append("\n"); 
		query.append("                                      #end" ).append("\n"); 
		query.append("                                      #if (${col} == '4') " ).append("\n"); 
		query.append("                                      AND A.CNTR_SZ_CD    = '6'" ).append("\n"); 
		query.append("                                      #end" ).append("\n"); 
		query.append("                                      AND A.FULL_MTY_CD     = DECODE(@[seq],'6','E','F')  )" ).append("\n"); 
		query.append("      WHEN MATCHED THEN" ).append("\n"); 
		query.append("          UPDATE  SET       " ).append("\n"); 
		query.append("                                          #if (${col} == '1') " ).append("\n"); 
		query.append("                                          CNTR_QTY = @[f_20_qty]" ).append("\n"); 
		query.append("                                          #end" ).append("\n"); 
		query.append("                                          #if (${col} == '2') " ).append("\n"); 
		query.append("                                          CNTR_QTY = @[f_40_qty]" ).append("\n"); 
		query.append("                                          #end" ).append("\n"); 
		query.append("                                          #if (${col} == '3') " ).append("\n"); 
		query.append("                                          CNTR_QTY = @[f_40h_qty]" ).append("\n"); 
		query.append("                                          #end" ).append("\n"); 
		query.append("                                          #if (${col} == '4') " ).append("\n"); 
		query.append("                                          CNTR_QTY = @[f_45_qty]" ).append("\n"); 
		query.append("                                          #end ," ).append("\n"); 
		query.append("                    UPD_USR_ID   =  @[cre_usr_id] ," ).append("\n"); 
		query.append("                    UPD_DT       = SYSDATE" ).append("\n"); 
		query.append("      WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("         INSERT ( VSL_CD ,          SKD_VOY_NO , SKD_DIR_CD ,       YD_CD," ).append("\n"); 
		query.append("                  POL_CLPT_IND_SEQ, CRR_CD,      POD_CD,            BLCK_STWG_CD," ).append("\n"); 
		query.append("                  CNTR_SZ_CD,       FULL_MTY_CD, CNTR_WGT_GRP_CD,   CNTR_QTY," ).append("\n"); 
		query.append("                  CRE_USR_ID,       CRE_DT,      UPD_USR_ID,        UPD_DT)" ).append("\n"); 
		query.append("         VALUES (substr(@[vvd],1,4),substr(@[vvd],5,4),substr(@[vvd],9,1), SUBSTR(@[yd_cd],1,7)," ).append("\n"); 
		query.append("                 SUBSTR(@[yd_cd],8,1),@[crr_cd], @[pod_cd],       @[blck_stwg_cd]," ).append("\n"); 
		query.append("                 #if (${col} == '1') '2' #end" ).append("\n"); 
		query.append("                 #if (${col} == '2') '4' #end" ).append("\n"); 
		query.append("                 #if (${col} == '3') '5' #end" ).append("\n"); 
		query.append("                 #if (${col} == '4') '6' #end , DECODE(@[seq],'6','E','F')," ).append("\n"); 
		query.append("                 DECODE(@[seq],'1','X','2','H','3','M','4','L','5','E','6','E')," ).append("\n"); 
		query.append("                 #if (${col} == '1')  @[f_20_qty]  #end" ).append("\n"); 
		query.append("                 #if (${col} == '2')  @[f_40_qty]  #end" ).append("\n"); 
		query.append("                 #if (${col} == '3')  @[f_40h_qty] #end" ).append("\n"); 
		query.append("                 #if (${col} == '4')  @[f_45_qty]  #end ," ).append("\n"); 
		query.append("                 @[cre_usr_id],  SYSDATE, @[cre_usr_id], SYSDATE )" ).append("\n"); 

	}
}