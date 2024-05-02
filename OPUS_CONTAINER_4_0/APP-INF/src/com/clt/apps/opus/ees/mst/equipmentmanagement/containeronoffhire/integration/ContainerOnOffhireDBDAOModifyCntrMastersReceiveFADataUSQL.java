/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOModifyCntrMastersReceiveFADataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.27
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2013.09.27 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOModifyCntrMastersReceiveFADataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCntrMastersReceiveFAData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOModifyCntrMastersReceiveFADataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fa_if_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fa_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fa_if_err_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fa_if_grp_seq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOModifyCntrMastersReceiveFADataUSQL").append("\n"); 
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
		query.append("#if (${gubun} == '0') " ).append("\n"); 
		query.append("UPDATE MST_CONTAINER" ).append("\n"); 
		query.append("SET FA_IF_DT = SYSDATE," ).append("\n"); 
		query.append("    FA_IF_STS_CD = DECODE(@[fa_if_sts_cd],'Y','C','E')," ).append("\n"); 
		query.append("    FA_IF_ERR_MSG = @[fa_if_err_msg]," ).append("\n"); 
		query.append("    FA_EQ_NO = @[fa_eq_no]," ).append("\n"); 
		query.append("    UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND CNTR_NO LIKE SUBSTR(@[eq_no], 1, 10) || '%'" ).append("\n"); 
		query.append("#elseif (${gubun} == '1') " ).append("\n"); 
		query.append("UPDATE MST_CONTAINER" ).append("\n"); 
		query.append("SET FA_IF_GRP_STS_CD = 'C'," ).append("\n"); 
		query.append("    UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND FA_IF_GRP_SEQ_NO = @[fa_if_grp_seq_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}