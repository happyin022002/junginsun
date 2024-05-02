/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOModifyCopDetailStsNBySPPUSQL.java
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

public class CopDetailReceiveDBDAOModifyCopDetailStsNBySPPUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCopDetailStsNBySPP
	  * </pre>
	  */
	public CopDetailReceiveDBDAOModifyCopDetailStsNBySPPUSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration ").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOModifyCopDetailStsNBySPPUSQL").append("\n"); 
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
		query.append("SET    act_sts_cd = 'C'" ).append("\n"); 
		query.append("WHERE (cop_no, cop_dtl_seq) IN" ).append("\n"); 
		query.append("(SELECT  (CASE WHEN LAG(c.act_sts_cd, 1,c.act_sts_cd)" ).append("\n"); 
		query.append("OVER (PARTITION BY c.cop_no" ).append("\n"); 
		query.append("ORDER BY c.cop_no,c.cop_dtl_seq) = 'F'" ).append("\n"); 
		query.append("AND  c.act_sts_cd = 'N'" ).append("\n"); 
		query.append("THEN c.cop_no" ).append("\n"); 
		query.append("END) aa" ).append("\n"); 
		query.append(",(CASE WHEN LAG(c.act_sts_cd, 1,c.act_sts_cd)" ).append("\n"); 
		query.append("OVER (PARTITION BY c.cop_no" ).append("\n"); 
		query.append("ORDER BY c.cop_no,c.cop_dtl_seq) = 'F'" ).append("\n"); 
		query.append("AND  c.act_sts_cd = 'N'" ).append("\n"); 
		query.append("THEN c.cop_dtl_seq" ).append("\n"); 
		query.append("END) bb" ).append("\n"); 
		query.append("FROM   sce_cop_dtl c" ).append("\n"); 
		query.append("WHERE  c.cop_no = @[v_cop_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}