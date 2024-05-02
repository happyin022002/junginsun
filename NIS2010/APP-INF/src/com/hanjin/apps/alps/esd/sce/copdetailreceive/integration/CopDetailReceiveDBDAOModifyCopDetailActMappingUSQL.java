/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOModifyCopDetailAtlMappingUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 김성일
*@LastVersion : 1.0
* 2009.09.25 김성일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungil Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOModifyCopDetailActMappingUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCopDetailAtlMapping
	  * </pre>
	  */
	public CopDetailReceiveDBDAOModifyCopDetailActMappingUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_act_rcv_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_act_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_act_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration ").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOModifyCopDetailAtlMappingUSQL").append("\n"); 
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
		query.append("UPDATE  sce_cop_dtl" ).append("\n"); 
		query.append("SET     act_dt         = to_date(@[in_act_dt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append(",act_rcv_tp_cd  = '2'" ).append("\n"); 
		query.append(",upd_usr_id     = DECODE(@[act_dt],NULL,'ACTVSL','ACTVSL2')" ).append("\n"); 
		query.append(",upd_dt         = SYSDATE" ).append("\n"); 
		query.append(",ACT_DAT_RCV_DT = CASE WHEN SUBSTR(@[in_vps_port_cd],1,5) IS NOT NULL" ).append("\n"); 
		query.append("THEN GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR('KRPUS',1,5), (select cre_dt from SCE_ACT_RCV_HIS where ACT_RCV_DT =@[in_act_rcv_dt] and ACT_RCV_NO = @[in_act_rcv_no] ), SUBSTR(@[in_vps_port_cd], 1,5))" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("WHERE   cop_no      = @[cop_no]" ).append("\n"); 
		query.append("AND     cop_dtl_seq = @[cop_dtl_seq]" ).append("\n"); 

	}
}