/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomerEdiDBDAOSearchCustStsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.28
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.01.28 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee YounJung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerEdiDBDAOSearchCustStsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCustSts
	  * </pre>
	  */
	public CustomerEdiDBDAOSearchCustStsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cs_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration ").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOSearchCustStsRSQL").append("\n"); 
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
		query.append("select substr(MAX (SYS_CONNECT_BY_PATH (cust_cd, ',')), 2) cust_cd," ).append("\n"); 
		query.append("substr(MAX (SYS_CONNECT_BY_PATH (edi_sts, ',')), 2) edi_sts" ).append("\n"); 
		query.append("from ( select A.cust_cd,A.edi_sts ,ROWNUM RNUM" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select /*+ ordered use_nl( grp cgo STS) */" ).append("\n"); 
		query.append("DISTINCT grp.edi_grp_cd cs_grp_id , STS.EDI_STS_SEQ ,cgo.cust_edi_sts_cd cust_cd,cgo.edi_stnd_sts_cd edi_sts" ).append("\n"); 
		query.append("from edi_group grp, edi_grp_cgo cgo,EDI_CGO_STND_STS STS" ).append("\n"); 
		query.append("where" ).append("\n"); 
		query.append("1=1" ).append("\n"); 
		query.append("#if(${cs_grp_id} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND grp.edi_grp_cd = @[cs_grp_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${edi_sts} !='')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("and cgo.edi_stnd_sts_cd  in (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach($ele IN ${edi_sts})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'$ele'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$ele'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if($velocityCount == 0 )" ).append("\n"); 
		query.append("''" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and grp.edi_grp_cd = cgo.edi_grp_cd" ).append("\n"); 
		query.append("AND grp.co_div_cd = cgo.co_div_cd" ).append("\n"); 
		query.append("AND STS.EDI_STND_STS_CD = cgo.EDI_STND_STS_CD" ).append("\n"); 
		query.append("ORDER BY STS.EDI_STS_SEQ" ).append("\n"); 
		query.append(") A )  START WITH rnum = 1 CONNECT BY PRIOR rnum = rnum - 1" ).append("\n"); 

	}
}