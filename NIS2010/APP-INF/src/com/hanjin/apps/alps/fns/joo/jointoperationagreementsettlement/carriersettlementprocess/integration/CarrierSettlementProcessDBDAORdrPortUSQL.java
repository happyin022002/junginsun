/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAORdrPortUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.12
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.05.12 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAORdrPortUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDR Port를 저장한다.
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAORdrPortUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAORdrPortUSQL").append("\n"); 
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
		query.append("MERGE INTO JOO_RDR_PORT A" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT  @[vsl_cd]		AS VSL_CD " ).append("\n"); 
		query.append("           ,@[skd_voy_no]	AS SKD_VOY_NO " ).append("\n"); 
		query.append("           ,@[skd_dir_cd]	AS SKD_DIR_CD  " ).append("\n"); 
		query.append("           ,@[vps_port_cd]	AS VPS_PORT_CD  " ).append("\n"); 
		query.append("           ,@[split_no] 	AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("		   ,@[rlane_cd]		AS SLAN_CD" ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("        A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("    AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND A.VPS_PORT_CD = B.VPS_PORT_CD" ).append("\n"); 
		query.append("    AND A.CLPT_IND_SEQ = B.CLPT_IND_SEQ    " ).append("\n"); 
		query.append("    AND A.SLAN_CD = B.SLAN_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET A.RDR_FLG = DECODE(@[rdr_flg],'R','Y','N')" ).append("\n"); 
		query.append("		  ,A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("          ,A.UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("     VSL_CD" ).append("\n"); 
		query.append("    ,SKD_VOY_NO" ).append("\n"); 
		query.append("    ,SKD_DIR_CD" ).append("\n"); 
		query.append("    ,VPS_PORT_CD" ).append("\n"); 
		query.append("    ,CLPT_IND_SEQ" ).append("\n"); 
		query.append("    ,CLPT_SEQ" ).append("\n"); 
		query.append("    ,SLAN_CD" ).append("\n"); 
		query.append("    ,YD_CD" ).append("\n"); 
		query.append("    ,VPS_ETD_DT" ).append("\n"); 
		query.append("    ,RDR_FLG" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID    " ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("     @[vsl_cd]" ).append("\n"); 
		query.append("    ,@[skd_voy_no]" ).append("\n"); 
		query.append("    ,@[skd_dir_cd]" ).append("\n"); 
		query.append("    ,@[vps_port_cd]" ).append("\n"); 
		query.append("    ,@[split_no]" ).append("\n"); 
		query.append("    ,@[clpt_seq]" ).append("\n"); 
		query.append("    ,@[rlane_cd]" ).append("\n"); 
		query.append("    ,@[vps_port_cd] || @[tml_cd]" ).append("\n"); 
		query.append("    ,TO_DATE(@[vps_etd_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("    ,DECODE(@[rdr_flg],'R','Y','N')" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("    ,@[usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("    ,@[usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}