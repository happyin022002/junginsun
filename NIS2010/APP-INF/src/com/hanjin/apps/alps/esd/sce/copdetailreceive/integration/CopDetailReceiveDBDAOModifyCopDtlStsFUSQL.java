/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOModifyCopDtlStsFUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 김성일
*@LastVersion : 1.0
* 2009.09.08 김성일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungil Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOModifyCopDtlStsFUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCopDtlStsF
	  * </pre>
	  */
	public CopDetailReceiveDBDAOModifyCopDtlStsFUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("IN_COP_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("v_cop_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOModifyCopDtlStsFUSQL").append("\n"); 
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
		query.append("update  sce_cop_dtl" ).append("\n"); 
		query.append("set  act_sts_cd = 'F'" ).append("\n"); 
		query.append("where  cop_no || to_char(cop_dtl_seq,'0000') < @[IN_COP_NO] || to_char(@[v_cop_dtl_seq],'0000')" ).append("\n"); 
		query.append("and  act_sts_cd in ('N','C')" ).append("\n"); 
		query.append("and  cop_no = @[IN_COP_NO]" ).append("\n"); 

	}
}