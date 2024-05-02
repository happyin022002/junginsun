/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CopDetailReceiveDBDAOModifyCopDetailNextStatusByVSKUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.13
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOModifyCopDetailNextStatusByVSKUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCopDetailNextStatusByVSK
	  * </pre>
	  */
	public CopDetailReceiveDBDAOModifyCopDetailNextStatusByVSKUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cop_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_msg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOModifyCopDetailNextStatusByVSKUSQL").append("\n"); 
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
		query.append("UPDATE  sce_cop_dtl " ).append("\n"); 
		query.append("SET     act_sts_cd     = 'F' " ).append("\n"); 
		query.append("       ,act_dt         = to_date(@[act_dt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("       ,act_rcv_tp_cd  = '2'" ).append("\n"); 
		query.append("       ,upd_usr_id     = 'ACTVSL'" ).append("\n"); 
		query.append("       ,upd_dt         = SYSDATE" ).append("\n"); 
		query.append("	   ,EDI_MSG_TP_CD  = @[edi_msg_tp_cd]" ).append("\n"); 
		query.append("       ,act_dat_rcv_dt = CASE WHEN SUBSTR(@[vps_port_cd],1,5) IS NOT NULL and act_dat_rcv_dt IS NULL" ).append("\n"); 
		query.append("                              THEN to_date(@[cre_dt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("                              ELSE act_dat_rcv_dt" ).append("\n"); 
		query.append("                         END            " ).append("\n"); 
		query.append("WHERE   cop_no      = @[cop_no]" ).append("\n"); 
		query.append("AND     cop_dtl_seq = @[cop_dtl_seq]" ).append("\n"); 

	}
}