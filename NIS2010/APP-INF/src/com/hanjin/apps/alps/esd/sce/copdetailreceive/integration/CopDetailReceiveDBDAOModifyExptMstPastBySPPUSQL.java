/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOModifyExptMstPastBySPPUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 김성일
*@LastVersion : 1.0
* 2009.09.11 김성일
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

public class CopDetailReceiveDBDAOModifyExptMstPastBySPPUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyExptMstPastBySPP
	  * </pre>
	  */
	public CopDetailReceiveDBDAOModifyExptMstPastBySPPUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("v_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("v_cop_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration ").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOModifyExptMstPastBySPPUSQL").append("\n"); 
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
		query.append("UPDATE SCE_EXPT_MST" ).append("\n"); 
		query.append("SET    COP_EXPT_STS_CD = 'R'" ).append("\n"); 
		query.append(",EXPT_CLR_TP_CD  = '2'" ).append("\n"); 
		query.append(",EXPT_RSOLV_DT   = SYSDATE" ).append("\n"); 
		query.append(",upd_usr_id      = 'SPP'" ).append("\n"); 
		query.append(",upd_dt          = SYSDATE" ).append("\n"); 
		query.append("WHERE cop_no = @[v_cop_no]" ).append("\n"); 
		query.append("AND   (cop_no || TRIM(TO_CHAR(cop_dtl_seq,'0000'))" ).append("\n"); 
		query.append("< @[v_cop_no] || TRIM(TO_CHAR(@[v_cop_dtl_seq],'0000')))" ).append("\n"); 
		query.append("AND   cop_expt_sts_cd = 'O'" ).append("\n"); 

	}
}