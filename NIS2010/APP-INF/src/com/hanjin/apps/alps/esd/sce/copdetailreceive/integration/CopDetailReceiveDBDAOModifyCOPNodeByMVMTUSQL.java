/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CopDetailReceiveDBDAOModifyCOPNodeByMVMTUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.22
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOModifyCOPNodeByMVMTUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCOPNodeByMVMT
	  * </pre>
	  */
	public CopDetailReceiveDBDAOModifyCOPNodeByMVMTUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_sts_mapg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOModifyCOPNodeByMVMTUSQL").append("\n"); 
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
		query.append("UPDATE SCE_COP_DTL D" ).append("\n"); 
		query.append("SET    D.NOD_CD = @[nod_cd]" ).append("\n"); 
		query.append("WHERE  D.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND    D.ACT_CD = DECODE(@[act_sts_mapg_cd],'MT','MITYAD','XX','MITYAD','OP','MOTYDO')" ).append("\n"); 
		query.append("AND    EXISTS  (" ).append("\n"); 
		query.append("SELECT  '1'" ).append("\n"); 
		query.append("FROM    MDM_LOCATION    DL," ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT  DZ," ).append("\n"); 
		query.append("MDM_LOCATION    NL," ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT  NZ" ).append("\n"); 
		query.append("WHERE   SUBSTR(D.NOD_CD, 1,5)       =   DL.LOC_CD" ).append("\n"); 
		query.append("AND     NVL(DL.SCC_CD,DL.LOC_CD)    =   DZ.SCC_CD" ).append("\n"); 
		query.append("AND     SUBSTR(@[nod_cd],1,5)       =   NL.LOC_CD" ).append("\n"); 
		query.append("AND     NVL(NL.SCC_CD,NL.LOC_CD)    =   NZ.SCC_CD" ).append("\n"); 
		query.append("AND     DZ.RCC_CD                   =   NZ.RCC_CD" ).append("\n"); 
		query.append("AND     ROWNUM                      =   1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}