/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ContainerMovementMasterDataMgtDBDAOCtmMvmtStsDcsnVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMasterDataMgtDBDAOCtmMvmtStsDcsnVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Update CTM_MVMT_STS_DCSN
	  * </pre>
	  */
	public ContainerMovementMasterDataMgtDBDAOCtmMvmtStsDcsnVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_gate_io_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mvmt_edi_msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_cntr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.integration ").append("\n"); 
		query.append("FileName : ContainerMovementMasterDataMgtDBDAOCtmMvmtStsDcsnVOUSQL").append("\n"); 
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
		query.append("UPDATE CTM_MVMT_STS_DCSN" ).append("\n"); 
		query.append("SET MVMT_STS_CD = @[mvmt_sts_cd]," ).append("\n"); 
		query.append("UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE MVMT_EDI_MSG_TP_ID = @[mvmt_edi_msg_tp_id]" ).append("\n"); 
		query.append("AND MVMT_EDI_IO_BND_CD = @[mvmt_edi_io_bnd_cd]" ).append("\n"); 
		query.append("AND MVMT_EDI_CNTR_STS_CD = @[mvmt_edi_cntr_sts_cd]" ).append("\n"); 
		query.append("AND MVMT_EDI_GATE_IO_CD = @[mvmt_edi_gate_io_cd]" ).append("\n"); 

	}
}