/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InlandLinkManageDBDAOPseudoTypeFormToCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.08.13 김귀진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kIm kwi-jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandLinkManageDBDAOPseudoTypeFormToCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PseudoTypeFormToCheck
	  * </pre>
	  */
	public InlandLinkManageDBDAOPseudoTypeFormToCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.integration ").append("\n"); 
		query.append("FileName : InlandLinkManageDBDAOPseudoTypeFormToCheckRSQL").append("\n"); 
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
		query.append("SELECT a.nod_tp_cd, c.fromCd," ).append("\n"); 
		query.append("b.nod_tp_cd, c.toCd," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN a.nod_tp_cd='P' AND b.nod_tp_cd='P' THEN '3'" ).append("\n"); 
		query.append("WHEN a.nod_tp_cd='P' AND b.nod_tp_cd<>'P' THEN '1'" ).append("\n"); 
		query.append("WHEN a.nod_tp_cd<>'P' AND b.nod_tp_cd='P' THEN '2'" ).append("\n"); 
		query.append("WHEN a.nod_tp_cd<>'P' AND b.nod_tp_cd<>'P' THEN '0'" ).append("\n"); 
		query.append("WHEN a.nod_tp_cd is null AND b.nod_tp_cd is null THEN '4'" ).append("\n"); 
		query.append("WHEN a.nod_tp_cd is null THEN '5'" ).append("\n"); 
		query.append("WHEN b.nod_tp_cd is null THEN '6'" ).append("\n"); 
		query.append("END AS ret" ).append("\n"); 
		query.append("FROM prd_node a,  prd_node b," ).append("\n"); 
		query.append("(select @[fromCd] fromCd, @[toCd] toCd from dual) c" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("nvl(a.DELT_FLG,'N') <>'Y'" ).append("\n"); 
		query.append("AND nvl(b.DELT_FLG,'N') <>'Y'" ).append("\n"); 
		query.append("and a.nod_cd(+) = c.fromCd" ).append("\n"); 
		query.append("and b.nod_cd(+) = c.toCd" ).append("\n"); 

	}
}