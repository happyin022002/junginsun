/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CopDetailReceiveDBDAOModifyCopDetailCurrentStatusBySPPUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.12
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.07.12 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOModifyCopDetailCurrentStatusBySPPUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCopDetailCurrentStatusBySPP
	  * </pre>
	  */
	public CopDetailReceiveDBDAOModifyCopDetailCurrentStatusBySPPUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rcv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dat_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOModifyCopDetailCurrentStatusBySPPUSQL").append("\n"); 
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
		query.append("UPDATE sce_cop_dtl" ).append("\n"); 
		query.append("SET    act_sts_cd     = 'F'" ).append("\n"); 
		query.append(",act_dt         = to_date(@[act_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append(",act_rcv_tp_cd  = @[act_rcv_tp_cd]" ).append("\n"); 
		query.append(",upd_usr_id     = @[upd_usr_id]" ).append("\n"); 
		query.append(",upd_dt         = SYSDATE" ).append("\n"); 
		query.append(",act_dat_rcv_dt  = CASE WHEN act_dat_rcv_dt IS NULL" ).append("\n"); 
		query.append("THEN to_date(@[act_dat_rcv_dt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("ELSE act_dat_rcv_dt" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("WHERE  act_sts_cd     = 'C'" ).append("\n"); 
		query.append("AND    cop_no         = @[cop_no]" ).append("\n"); 
		query.append("AND    cop_dtl_seq    = @[cop_dtl_seq]" ).append("\n"); 

	}
}