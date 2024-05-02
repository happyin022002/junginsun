/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ProductCatalogcreateDBDAOSelectEmptyPuYdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.29
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogcreateDBDAOSelectEmptyPuYdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SelectEmptyPuYd
	  * </pre>
	  */
	public ProductCatalogcreateDBDAOSelectEmptyPuYdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("m_pu",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("m_pu_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogcreateDBDAOSelectEmptyPuYdRSQL").append("\n"); 
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
		query.append("WITH MT AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT MT,ORD,PCTL_NO,ARR_ST_DT" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT MT,ORD,PCTL_NO, ARR_ST_DT, " ).append("\n"); 
		query.append("    		   RANK() OVER(PARTITION BY MT ORDER BY ORD) RK" ).append("\n"); 
		query.append("        FROM " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("            SELECT DISTINCT MTY_PKUP_YD_CD MT, 1 ORD, pctl_no ," ).append("\n"); 
		query.append("                   decode(@[m_pu_dt], null, (select to_char(ARR_ST_DT ,'yyyymmdd' ) from prd_prod_ctl_rout_dtl d " ).append("\n"); 
		query.append("    									    where d.pctl_no= m.pctl_no and d.DEST_NOD_CD = m.MTY_PKUP_YD_CD and d.MTY_YD_FLG='Y' and d.PCTL_SEQ=1 and rownum=1 )," ).append("\n"); 
		query.append("    							    @[m_pu_dt]) ARR_ST_DT" ).append("\n"); 
		query.append("            FROM PRD_PROD_CTL_MST M WHERE M.PCTL_NO = @[pctl_no] --'CHO%'" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT @[m_pu], 2 ORD, '' pctl_no, '' ARR_ST_DT FROM DUAL where  @[m_pu] not in ( select MTY_PKUP_YD_CD from prd_prod_ctl_mst m WHERE M.PCTL_NO = @[pctl_no])" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT DISTINCT MTY_PKUP_RTN_YD_CD MT , 3 ORD, '' pctl_no , '' ARR_ST_DT " ).append("\n"); 
		query.append("            FROM  PRD_PKUP_RTN_YD P," ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT  " ).append("\n"); 
		query.append("                POR_CD,POL_CD,VSL_SLAN_CD,RF_SPCL_FLG,DG_SPCL_FLG,SPCL_AWK_CGO_FLG, m.pctl_no" ).append("\n"); 
		query.append("                FROM PRD_PROD_CTL_MST M,PRD_PROD_CTL_ROUT_DTL D " ).append("\n"); 
		query.append("                WHERE M.PCTL_NO = @[pctl_no] " ).append("\n"); 
		query.append("                AND M.PCTL_NO =D.PCTL_NO" ).append("\n"); 
		query.append("                AND D.PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append("                AND D.TRSP_MOD_CD IN ('WD','VD')" ).append("\n"); 
		query.append("                AND SUBSTR(D.ORG_NOD_CD,1,5) = M.POL_CD" ).append("\n"); 
		query.append("            ) T" ).append("\n"); 
		query.append("            WHERE POR_DEL_CD=POR_CD " ).append("\n"); 
		query.append("			AND POL_POD_CD=POL_CD " ).append("\n"); 
		query.append("			AND P.VSL_SLAN_CD IN (T.VSL_SLAN_CD,'ALL') " ).append("\n"); 
		query.append("			AND P.IO_BND_CD IN ('O','B')" ).append("\n"); 
		query.append("            AND SPCL_CGO_CD IN ( DECODE(T.DG_SPCL_FLG,'Y','DG','AL')," ).append("\n"); 
		query.append("                                 DECODE(T.RF_SPCL_FLG,'Y','RF','AL')," ).append("\n"); 
		query.append("                                 DECODE(T.RF_SPCL_FLG||T.DG_SPCL_FLG||T.SPCL_AWK_CGO_FLG,'NNN','DR')," ).append("\n"); 
		query.append("                                 DECODE(T.SPCL_AWK_CGO_FLG,'Y','FO','AL')," ).append("\n"); 
		query.append("                                 'AL')" ).append("\n"); 
		query.append("    		AND MTY_PKUP_RTN_YD_CD not in ( select MTY_PKUP_YD_CD from prd_prod_ctl_mst m WHERE M.PCTL_NO = @[pctl_no] )" ).append("\n"); 
		query.append("    		UNION ALL" ).append("\n"); 
		query.append("            SELECT YD_CD MT, 4 ORD, '' pctl_no , '' ARR_ST_DT  FROM mdm_yard WHERE SUBSTR(yd_cd,1,5) =" ).append("\n"); 
		query.append("            													(SELECT SCC_CD FROM mdm_location WHERE LOC_CD=(SELECT POR_CD FROM PRD_PROD_CTL_MST WHERE PCTL_NO =@[pctl_no]) AND NVL(DELT_FLG,'N')='N' )  " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("        WHERE MT IS NOT NULL" ).append("\n"); 
		query.append("        order by pctl_no" ).append("\n"); 
		query.append("   ) WHERE RK =1        " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select m.mt YD_CD, (select nod_nm from prd_node where nod_cd = m.mt) NOD_NM,D2,D4,D5,R2,R4,R5,M.PCTL_NO,T.ARR_ST_DT " ).append("\n"); 
		query.append("from " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("    SELECT YD_CD," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    NVL(SUM(D2),0) D2," ).append("\n"); 
		query.append("    NVL(SUM(D4),0) D4," ).append("\n"); 
		query.append("    NVL(SUM(D5),0) D5," ).append("\n"); 
		query.append("    NVL(SUM(R2),0) R2," ).append("\n"); 
		query.append("    NVL(SUM(R4),0) R4," ).append("\n"); 
		query.append("    NVL(SUM(R5),0) R5 " ).append("\n"); 
		query.append("    ,(select pctl_no from prd_prod_ctl_mst where pctl_no = @[pctl_no] and  MTY_PKUP_YD_CD= yd_cd and rownum=1) pctl_no" ).append("\n"); 
		query.append("    ,(select to_char(ARR_ST_DT, 'yyyymmdd') from prd_prod_ctl_rout_dtl where pctl_no = @[pctl_no] and DEST_NOD_CD = yd_cd and MTY_YD_FLG='Y' and PCTL_SEQ=1 and rownum=1) ARR_ST_DT" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT  " ).append("\n"); 
		query.append("        YD_CD,CNTR_TPSZ_CD,FCAST_QTY||''  D2, '' D4,'' D5,'' R2,'' R4,'' R5" ).append("\n"); 
		query.append("        FROM  CIM_AVAL_SMRY" ).append("\n"); 
		query.append("        WHERE YD_CD IN (SELECT MT FROM MT ) --'?????'" ).append("\n"); 
		query.append("        AND   FCAST_DT = TO_DATE( (SELECT ARR_ST_DT FROM MT where pctl_no is not null and  rownum=1) ,'YYYYMMDD') --TO_DATE('20090813','YYYYMMDD')" ).append("\n"); 
		query.append("        AND   CNTR_TPSZ_CD ='D2' --'??'" ).append("\n"); 
		query.append("        AND   CNTR_AVAL_FCAST_TP_CD = 'EA'" ).append("\n"); 
		query.append("        AND   CO_CD ='H' " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  " ).append("\n"); 
		query.append("        YD_CD,CNTR_TPSZ_CD,''  D2, FCAST_QTY||'' D4,'' D5,'' R2,'' R4,'' R5" ).append("\n"); 
		query.append("        FROM  CIM_AVAL_SMRY" ).append("\n"); 
		query.append("        WHERE YD_CD IN (SELECT MT FROM MT ) --('KRPUSYG','KRPUSHN' ) --'?????'" ).append("\n"); 
		query.append("        AND   FCAST_DT =   TO_DATE( (SELECT ARR_ST_DT FROM MT where pctl_no is not null and  rownum=1) ,'YYYYMMDD') --TO_DATE('20090813','YYYYMMDD')" ).append("\n"); 
		query.append("        AND   CNTR_TPSZ_CD ='D4' --'??'" ).append("\n"); 
		query.append("        AND   CNTR_AVAL_FCAST_TP_CD = 'EA'" ).append("\n"); 
		query.append("        AND   CO_CD ='H'     " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  " ).append("\n"); 
		query.append("        YD_CD,CNTR_TPSZ_CD,''  D2, '' D4,FCAST_QTY||'' D5,'' R2,'' R4,'' R5" ).append("\n"); 
		query.append("        FROM  CIM_AVAL_SMRY" ).append("\n"); 
		query.append("        WHERE YD_CD IN (SELECT MT FROM MT ) --('KRPUSYG','KRPUSHN' ) --'?????'" ).append("\n"); 
		query.append("        AND   FCAST_DT =  TO_DATE( (SELECT ARR_ST_DT FROM MT where pctl_no is not null and  rownum=1) ,'YYYYMMDD')   --TO_DATE('20090813','YYYYMMDD')" ).append("\n"); 
		query.append("        AND   CNTR_TPSZ_CD ='D5' --'??'" ).append("\n"); 
		query.append("        AND   CNTR_AVAL_FCAST_TP_CD = 'EA'" ).append("\n"); 
		query.append("        AND   CO_CD ='H'      " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  " ).append("\n"); 
		query.append("        YD_CD,CNTR_TPSZ_CD,''  D2, '' D4,'' D5,FCAST_QTY||'' R2,'' R4,'' R5" ).append("\n"); 
		query.append("        FROM  CIM_AVAL_SMRY" ).append("\n"); 
		query.append("        WHERE YD_CD IN (SELECT MT FROM MT ) --('KRPUSYG','KRPUSHN' ) --'?????'" ).append("\n"); 
		query.append("        AND   FCAST_DT =  TO_DATE( (SELECT ARR_ST_DT FROM MT where pctl_no is not null and  rownum=1) ,'YYYYMMDD')   --TO_DATE('20090813','YYYYMMDD')" ).append("\n"); 
		query.append("        AND   CNTR_TPSZ_CD ='R2' --'??'" ).append("\n"); 
		query.append("        AND   CNTR_AVAL_FCAST_TP_CD = 'EA'" ).append("\n"); 
		query.append("        AND   CO_CD ='H'      " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  " ).append("\n"); 
		query.append("        YD_CD,CNTR_TPSZ_CD,''  D2, '' D4,'' D5,'' R2,FCAST_QTY||'' R4,'' R5" ).append("\n"); 
		query.append("        FROM  CIM_AVAL_SMRY" ).append("\n"); 
		query.append("        WHERE YD_CD IN (SELECT MT FROM MT ) --('KRPUSYG','KRPUSHN' ) --'?????'" ).append("\n"); 
		query.append("        AND   FCAST_DT =  TO_DATE( (SELECT ARR_ST_DT FROM MT where pctl_no is not null and  rownum=1) ,'YYYYMMDD')    --TO_DATE('20090813','YYYYMMDD')" ).append("\n"); 
		query.append("        AND   CNTR_TPSZ_CD ='R4' --'??'" ).append("\n"); 
		query.append("        AND   CNTR_AVAL_FCAST_TP_CD = 'EA'" ).append("\n"); 
		query.append("        AND   CO_CD ='H'   " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  " ).append("\n"); 
		query.append("        YD_CD,CNTR_TPSZ_CD,''  D2, '' D4,'' D5,'' R2,'' R4,FCAST_QTY||'' R5" ).append("\n"); 
		query.append("        FROM  CIM_AVAL_SMRY" ).append("\n"); 
		query.append("        WHERE YD_CD IN (SELECT MT FROM MT ) --('KRPUSYG','KRPUSHN' ) --'?????'" ).append("\n"); 
		query.append("        AND   FCAST_DT =  TO_DATE( (SELECT ARR_ST_DT FROM MT where pctl_no is not null and  rownum=1) ,'YYYYMMDD')   --TO_DATE('20090813','YYYYMMDD')" ).append("\n"); 
		query.append("        AND   CNTR_TPSZ_CD ='R5' --'??'" ).append("\n"); 
		query.append("        AND   CNTR_AVAL_FCAST_TP_CD = 'EA'" ).append("\n"); 
		query.append("        AND   CO_CD ='H'        " ).append("\n"); 
		query.append("    ) " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    GROUP BY YD_CD " ).append("\n"); 
		query.append(") t, mt m" ).append("\n"); 
		query.append("where m.mt = t.yd_cd(+)" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("'' YD_CD,'Input yourSelf' NOD_NM, null D2, null D4,null D5,null R2,null R4, null R5, null PCTL_NO, null ARR_ST_DT" ).append("\n"); 
		query.append("from dual" ).append("\n"); 
		query.append("order by pctl_no,YD_CD" ).append("\n"); 

	}
}