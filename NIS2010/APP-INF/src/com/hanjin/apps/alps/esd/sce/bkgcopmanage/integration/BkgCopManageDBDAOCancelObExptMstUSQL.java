/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCopManageDBDAOCancelObExptMstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.10.21 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOCancelObExptMstUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Outbound 의 Exception 정보를 cancel 하고 notify 대상에서 제외시킨다.
	  * </pre>
	  */
	public BkgCopManageDBDAOCancelObExptMstUSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOCancelObExptMstUSQL").append("\n"); 
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
		query.append("SET    COP_EXPT_STS_CD = 'X'" ).append("\n"); 
		query.append(",NTFD_FLG        = 'N'" ).append("\n"); 
		query.append(",UPD_USR_ID = 'TRO O'" ).append("\n"); 
		query.append(",UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE  COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND    COP_DTL_SEQ < 4000" ).append("\n"); 
		query.append("AND    COP_EXPT_STS_CD in ('O','R')" ).append("\n"); 

	}
}