/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OpfUtilDBDAOsearchMdmVslCntrInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OpfUtilDBDAOsearchMdmVslCntrInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dd
	  * </pre>
	  */
	public OpfUtilDBDAOsearchMdmVslCntrInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.integration").append("\n"); 
		query.append("FileName : OpfUtilDBDAOsearchMdmVslCntrInfoListRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD, DECODE(CRR_CD||VSL_OWN_IND_CD, 'SMLO', 'CO', 'CC') AS VSL_OSHP_CNTR_BLK_TP_CD" ).append("\n"); 
		query.append("               , (" ).append("\n"); 
		query.append("                SELECT  S.INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("                FROM    COM_INTG_CD_DTL S" ).append("\n"); 
		query.append("                WHERE   S.INTG_CD_ID    = 'CD02594'" ).append("\n"); 
		query.append("                AND     S.INTG_CD_VAL_CTNT  = DECODE(CRR_CD||VSL_OWN_IND_CD, 'SMLO', 'CO', 'CC')" ).append("\n"); 
		query.append("               ) AS VSL_OSHP_CNTR_BLK_TP_CD_DESC" ).append("\n"); 
		query.append("FROM  MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE  VSL_CD = @[vsl_cd]" ).append("\n"); 

	}
}