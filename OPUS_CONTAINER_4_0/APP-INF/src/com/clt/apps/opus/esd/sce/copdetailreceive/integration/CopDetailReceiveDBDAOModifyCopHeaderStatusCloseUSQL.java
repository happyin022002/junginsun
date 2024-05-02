/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CopDetailReceiveDBDAOModifyCopHeaderStatusCloseUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.31
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOModifyCopHeaderStatusCloseUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCopHeaderStatusClose
	  * </pre>
	  */
	public CopDetailReceiveDBDAOModifyCopHeaderStatusCloseUSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOModifyCopHeaderStatusCloseUSQL").append("\n"); 
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
		query.append("update sce_cop_hdr H " ).append("\n"); 
		query.append("set    H.cop_sts_cd  = 'F'" ).append("\n"); 
		query.append("      ,H.upd_dt      = SYSDATE" ).append("\n"); 
		query.append("      ,H.upd_usr_id  = 'MVMT Close'" ).append("\n"); 
		query.append("      ,H.cop_fsh_dt  = (select max(D.ACT_DT) from sce_cop_dtl D where substr(D.ACT_CD, 1,1) <> 'M' and D.ACT_DT is not null and D.cop_no  IN (@[cop_no],H.cop_no) )" ).append("\n"); 
		query.append("where  H.MST_cop_no  = @[cop_no] " ).append("\n"); 
		query.append("AND   (H.COP_STS_CD != 'F' OR   H.cop_fsh_dt IS NULL) " ).append("\n"); 
		query.append("AND    H.COP_STS_CD != 'X'" ).append("\n"); 

	}
}