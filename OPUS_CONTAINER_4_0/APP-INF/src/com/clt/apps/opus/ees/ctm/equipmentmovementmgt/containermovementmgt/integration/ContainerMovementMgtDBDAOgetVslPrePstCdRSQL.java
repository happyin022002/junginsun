/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOgetVslPrePstCdRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.04
*@LastModifier :
*@LastVersion : 1.0
* 2009.07.04
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyung Min Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOgetVslPrePstCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * VD의 다음 상태가 T일때 다음배를 찾아 옴
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOgetVslPrePstCdRSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT vsl_pre_pst_cd" ).append("\n");
		query.append("FROM bkg_vvd" ).append("\n");
		query.append("WHERE bkg_no = @[bkg_no] AND vsl_pre_pst_cd = 'U'" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration ").append("\n");
		query.append("FileName : ContainerMovementMgtDBDAOgetVslPrePstCdRSQL").append("\n");
		query.append("*/").append("\n");
	}
}