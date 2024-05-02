/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IrregularManageDBDAORemoveIrregularUSQL.java
*@FileTitle : Irregular Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.29 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IrregularManageDBDAORemoveIrregularUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Irregular Header Delete
	  * </pre>
	  */
	public IrregularManageDBDAORemoveIrregularUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("irr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.integration ").append("\n"); 
		query.append("FileName : IrregularManageDBDAORemoveIrregularUSQL").append("\n"); 
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
		query.append("UPDATE	TES_IRR_HDR SET" ).append("\n"); 
		query.append("DELT_FLG	= 'Y'" ).append("\n"); 
		query.append(", UPD_USR_ID	= @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT		= SYSDATE" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("AND		IRR_NO		= @[irr_no]" ).append("\n"); 

	}
}