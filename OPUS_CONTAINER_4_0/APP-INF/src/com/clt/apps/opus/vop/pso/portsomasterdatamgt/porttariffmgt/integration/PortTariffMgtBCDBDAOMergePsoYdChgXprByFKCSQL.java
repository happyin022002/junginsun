/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOMergePsoYdChgXprByFKCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.16
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.11.16 정명훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOMergePsoYdChgXprByFKCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSO_YD_CHG_XPR <merge By FK>
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOMergePsoYdChgXprByFKCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_xpr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pso_chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_pgm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOMergePsoYdChgXprByFKCSQL").append("\n"); 
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
		query.append("MERGE INTO PSO_YD_CHG_XPR A   -- 의미상 Key" ).append("\n"); 
		query.append("USING DUAL ON (A.PSO_CHG_TP_CD      = @[pso_chg_tp_cd]" ).append("\n"); 
		query.append("AND A.YD_CHG_NO      = @[yd_chg_no]" ).append("\n"); 
		query.append("AND A.YD_CHG_VER_SEQ = @[yd_chg_ver_seq])" ).append("\n"); 
		query.append("WHEN MATCHED" ).append("\n"); 
		query.append("THEN UPDATE SET" ).append("\n"); 
		query.append("A.CHG_XPR_NO       = @[chg_xpr_no]" ).append("\n"); 
		query.append(",A.UPD_USR_ID       = @[cre_usr_id]" ).append("\n"); 
		query.append(",A.UPD_DT           = SYSDATE" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    A.PSO_CHG_TP_CD  = @[pso_chg_tp_cd]" ).append("\n"); 
		query.append("AND    A.YD_CHG_NO      = @[yd_chg_no]" ).append("\n"); 
		query.append("AND    A.YD_CHG_VER_SEQ = @[yd_chg_ver_seq]" ).append("\n"); 
		query.append("WHEN NOT MATCHED" ).append("\n"); 
		query.append("THEN INSERT (A.YD_CHG_XPR_NO" ).append("\n"); 
		query.append(",A.PSO_CHG_TP_CD" ).append("\n"); 
		query.append(",A.XTER_PGM_FLG" ).append("\n"); 
		query.append(",A.YD_CHG_NO" ).append("\n"); 
		query.append(",A.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append(",A.CHG_XPR_NO" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",A.CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",A.UPD_DT)" ).append("\n"); 
		query.append("VALUES ((SELECT /*+ INDEX_DESC(Z XPKPSO_YD_CHG_XPR) */ NVL(MAX(Z.YD_CHG_XPR_NO), 0) + 1 YD_CHG_XPR_NO" ).append("\n"); 
		query.append("FROM   PSO_YD_CHG_XPR Z" ).append("\n"); 
		query.append("WHERE  ROWNUM = 1)" ).append("\n"); 
		query.append(",@[pso_chg_tp_cd]" ).append("\n"); 
		query.append(",@[xter_pgm_flg]" ).append("\n"); 
		query.append(",@[yd_chg_no]" ).append("\n"); 
		query.append(",@[yd_chg_ver_seq]" ).append("\n"); 
		query.append(",@[chg_xpr_no]" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}