/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOgetMaxCycNoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier :
*@LastVersion : 1.0
* 2009.07.06
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyung Min Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOgetMaxCycNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 컨테이너에 딸려있는 부킹번호중 하나를 얻어온다. (최종 값)
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOgetMaxCycNoRSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT  /*+ INDEX_DESC(BKG_CONTAINER XAK1BKG_CONTAINER) */" ).append("\n");
		query.append("BKG_NO" ).append("\n");
		query.append("FROM BKG_CONTAINER" ).append("\n");
		query.append("WHERE CNTR_NO = @[cntr_no]  AND ROWNUM = 1" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n");
		query.append("FileName : ContainerMovementMgtDBDAOgetMaxCycNoRSQL").append("\n");
		query.append("*/").append("\n");
	}
}