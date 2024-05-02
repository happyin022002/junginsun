/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOModifyCopDetailNextStatusUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOModifyCopDetailNextStatusUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCopDetailNextStatus
	  * </pre>
	  */
	public CopDetailReceiveDBDAOModifyCopDetailNextStatusUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration ").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOModifyCopDetailNextStatusUSQL").append("\n"); 
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
		query.append("set  act_sts_cd = 'C'" ).append("\n"); 
		query.append("where  (cop_no, cop_dtl_seq) in" ).append("\n"); 
		query.append("(select (case when lag(c.act_sts_cd, 1, c.act_sts_cd)" ).append("\n"); 
		query.append("over (partition by c.cop_no" ).append("\n"); 
		query.append("order by c.cop_no, c.cop_dtl_seq) = 'F'" ).append("\n"); 
		query.append("and c.act_sts_cd = 'N' then c.cop_no end) aa ," ).append("\n"); 
		query.append("(case when lag(c.act_sts_cd, 1, c.act_sts_cd)" ).append("\n"); 
		query.append("over (partition by c.cop_no" ).append("\n"); 
		query.append("order by c.cop_no, c.cop_dtl_seq) = 'F'" ).append("\n"); 
		query.append("and c.act_sts_cd = 'N' then c.cop_dtl_seq end) bb" ).append("\n"); 
		query.append("from  sce_cop_dtl c" ).append("\n"); 
		query.append("where c.cop_no = @[cop_no] )" ).append("\n"); 
		query.append("and     cop_no = @[cop_no]" ).append("\n"); 

	}
}