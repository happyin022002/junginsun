/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TCharterIOBunkerRegisterDAOFmsContractByBunkerUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOBunkerRegisterDAOFmsContractByBunkerUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOBunkerRegisterDAOFmsContractByBunkerUSQL
	  * </pre>
	  */
	public TCharterIOBunkerRegisterDAOFmsContractByBunkerUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doil_bor_out_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_doil_bod_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doil_bod_out_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_foil_bor_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_bod_out_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_foil_bod_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bod_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_bor_out_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_doil_bor_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bor_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration").append("\n"); 
		query.append("FileName : TCharterIOBunkerRegisterDAOFmsContractByBunkerUSQL").append("\n"); 
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
		query.append("update fms_contract" ).append("\n"); 
		query.append("   set act_foil_bod_qty = DECODE(@[act_foil_bod_qty],null,act_foil_bod_qty,@[act_foil_bod_qty])," ).append("\n"); 
		query.append("	   act_doil_bod_qty = DECODE(@[act_doil_bod_qty],null,act_doil_bod_qty,@[act_doil_bod_qty])," ).append("\n"); 
		query.append("	   act_foil_bor_qty = DECODE(@[act_foil_bor_qty],null,act_foil_bor_qty,@[act_foil_bor_qty])," ).append("\n"); 
		query.append("	   act_doil_bor_qty = DECODE(@[act_doil_bor_qty],null,act_doil_bor_qty,@[act_doil_bor_qty])," ).append("\n"); 
		query.append("	   foil_bod_out_prc = DECODE(@[foil_bod_out_prc],null,foil_bod_out_prc,@[foil_bod_out_prc])," ).append("\n"); 
		query.append("	   doil_bod_out_prc = DECODE(@[doil_bod_out_prc],null,doil_bod_out_prc,@[doil_bod_out_prc])," ).append("\n"); 
		query.append("	   foil_bor_out_prc = DECODE(@[foil_bor_out_prc],null,foil_bor_out_prc,@[foil_bor_out_prc])," ).append("\n"); 
		query.append("	   doil_bor_out_prc = DECODE(@[doil_bor_out_prc],null,doil_bor_out_prc,@[doil_bor_out_prc])," ).append("\n"); 
		query.append("       bod_port_cd = DECODE(@[bod_port_cd],null,bod_port_cd,@[bod_port_cd])," ).append("\n"); 
		query.append("       bor_port_cd = DECODE(@[bor_port_cd],null,bor_port_cd,@[bor_port_cd])" ).append("\n"); 
		query.append(" where flet_ctrt_no = @[flet_ctrt_no]" ).append("\n"); 

	}
}