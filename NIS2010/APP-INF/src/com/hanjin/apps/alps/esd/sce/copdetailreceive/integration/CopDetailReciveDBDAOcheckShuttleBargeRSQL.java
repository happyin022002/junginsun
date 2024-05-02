/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CopDetailReciveDBDAOcheckShuttleBargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.16
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.16 
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

public class CopDetailReciveDBDAOcheckShuttleBargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * T/S 지역 Barge Case인지 체크한다.
	  * </pre>
	  */
	public CopDetailReciveDBDAOcheckShuttleBargeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cop_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration ").append("\n"); 
		query.append("FileName : CopDetailReciveDBDAOcheckShuttleBargeRSQL").append("\n"); 
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
		query.append("SELECT  NVL( MAX(1), 0 ) -- 1 : TRUE , 0 : FALSE" ).append("\n"); 
		query.append("FROM    SCE_COP_DTL	D" ).append("\n"); 
		query.append("WHERE   D.COP_NO	=		@[cop_no]" ).append("\n"); 
		query.append("AND     D.NOD_CD	LIKE    SUBSTR(@[nod_cd],1,5) ||'%'" ).append("\n"); 
		query.append("AND		D.ACT_CD	=" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN @[act_cd] = 'FTWMDO'   THEN    'FTWMAD'" ).append("\n"); 
		query.append("WHEN @[act_cd] = 'FTWMAD'   THEN    'FTWMDO'" ).append("\n"); 
		query.append("ELSE                                'ERROR'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("AND		D.COP_DTL_SEQ	=" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN @[act_cd] = 'FTWMDO'   THEN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	MIN(DD.COP_DTL_SEQ)" ).append("\n"); 
		query.append("FROM	SCE_COP_DTL	DD" ).append("\n"); 
		query.append("WHERE	DD.COP_NO		=	D.COP_NO" ).append("\n"); 
		query.append("AND		DD.COP_DTL_SEQ	>	@[cop_dtl_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN @[act_cd] = 'FTWMAD'   THEN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	MAX(DD.COP_DTL_SEQ)" ).append("\n"); 
		query.append("FROM	SCE_COP_DTL	DD" ).append("\n"); 
		query.append("WHERE	DD.COP_NO		=	D.COP_NO" ).append("\n"); 
		query.append("AND		DD.COP_DTL_SEQ	<	@[cop_dtl_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ELSE	0" ).append("\n"); 
		query.append("END" ).append("\n"); 

	}
}