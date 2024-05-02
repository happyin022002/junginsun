/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOModifyCopDetailExptResolveType2USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.29
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOModifyCopDetailExptResolveType2USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCopDetailExptResolveType2
	  * </pre>
	  */
	public CopDetailReceiveDBDAOModifyCopDetailExptResolveType2USQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration ").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOModifyCopDetailExptResolveType2USQL").append("\n"); 
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
		query.append("update sce_expt_mst" ).append("\n"); 
		query.append("set    cop_expt_sts_cd = 'R'" ).append("\n"); 
		query.append(",expt_clr_tp_cd  = '2'" ).append("\n"); 
		query.append(",expt_rsolv_dt   = sysdate" ).append("\n"); 
		query.append(",upd_usr_id      = 'VSL'" ).append("\n"); 
		query.append(",upd_dt          = sysdate" ).append("\n"); 
		query.append("where cop_no = @[cop_no]" ).append("\n"); 
		query.append("and   (cop_no || trim(to_char(cop_dtl_seq,'0000')) < @[cop_no] || trim(to_char(@[cop_dtl_seq],'0000')))" ).append("\n"); 
		query.append("AND   cop_expt_sts_cd = 'O'" ).append("\n"); 

	}
}