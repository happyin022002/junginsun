/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EdiHoldStatusReceiveDAOAddHoldStatusCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.05
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.receiveeai.holdstatusreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EdiHoldStatusReceiveDAOAddHoldStatusCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCE_RAIL_HLD_STS 테이블에 Insert 한다.
	  * </pre>
	  */
	public EdiHoldStatusReceiveDAOAddHoldStatusCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hold_sts_customs_time",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hold_sts_terminal_time",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("last_release_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("send_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hold_sts_customs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hold_sts_carrier_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hold_sts_usda_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hold_sts_carrier_time",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hold_sts_usda_time",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hold_sts_carrier",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hold_sts_terminal_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hold_sts_customs_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("last_release_time",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hold_sts_usda",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ssco_scac",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hold_sts_terminal",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.receiveeai.holdstatusreceive.integration").append("\n"); 
		query.append("FileName : EdiHoldStatusReceiveDAOAddHoldStatusCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_RAIL_HLD_STS(" ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("RAIL_HLD_STS_SND_DT," ).append("\n"); 
		query.append("REF_NO," ).append("\n"); 
		query.append("RAIL_HLD_STS_RCV_DT," ).append("\n"); 
		query.append("STND_CRR_CD," ).append("\n"); 
		query.append("CSTMS_HLD_STS_CD," ).append("\n"); 
		query.append("CSTMS_HLD_STS_DT," ).append("\n"); 
		query.append("USDA_HLD_STS_CD," ).append("\n"); 
		query.append("USDA_HLD_STS_DT," ).append("\n"); 
		query.append("CRR_HLD_STS_CD," ).append("\n"); 
		query.append("CRR_HLD_STS_DT," ).append("\n"); 
		query.append("TML_HLD_STS_CD," ).append("\n"); 
		query.append("TML_HLD_STS_DT," ).append("\n"); 
		query.append("LST_HLD_STS_CD," ).append("\n"); 
		query.append("LST_RLSE_DT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("@[bkg_no]," ).append("\n"); 
		query.append("@[cntr_no]," ).append("\n"); 
		query.append("@[send_date]," ).append("\n"); 
		query.append("@[ref_no]," ).append("\n"); 
		query.append("TO_CHAR(SYSDATE, 'YYYYMMDD')," ).append("\n"); 
		query.append("@[ssco_scac]," ).append("\n"); 
		query.append("@[hold_sts_customs]," ).append("\n"); 
		query.append("CASE WHEN @[hold_sts_customs_date]  = NULL then NULL" ).append("\n"); 
		query.append("ELSE TO_DATE(@[hold_sts_customs_date]||@[hold_sts_customs_time], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("END," ).append("\n"); 
		query.append("@[hold_sts_usda]," ).append("\n"); 
		query.append("CASE WHEN @[hold_sts_usda_date]  = NULL then NULL" ).append("\n"); 
		query.append("ELSE TO_DATE(@[hold_sts_usda_date]||@[hold_sts_usda_time], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("END," ).append("\n"); 
		query.append("@[hold_sts_carrier]," ).append("\n"); 
		query.append("CASE WHEN @[hold_sts_carrier_date]  = NULL then NULL" ).append("\n"); 
		query.append("ELSE TO_DATE(@[hold_sts_carrier_date]||@[hold_sts_carrier_time], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("END," ).append("\n"); 
		query.append("@[hold_sts_terminal]," ).append("\n"); 
		query.append("CASE WHEN @[hold_sts_terminal_date]  = NULL then NULL" ).append("\n"); 
		query.append("ELSE TO_DATE(@[hold_sts_terminal_date]||@[hold_sts_terminal_time], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("END," ).append("\n"); 
		query.append("NULL," ).append("\n"); 
		query.append("CASE WHEN @[last_release_date]  = NULL then NULL" ).append("\n"); 
		query.append("ELSE TO_DATE(@[last_release_date]||@[last_release_time], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("END," ).append("\n"); 
		query.append("@[sender_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[sender_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}